package io.example.library;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.example.library.service.UserService;
import io.example.library.service.dto.BookDTO;
import io.example.library.service.dto.BorrowDTO;
import io.example.library.service.dto.GenderDTO;
import io.example.library.service.dto.UserDTO;
import io.example.library.service.BookService;
import io.example.library.web.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Component
public class AppInitializer {
    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    private final Set<BookDTO> bookDTOs = new HashSet<>();

    @EventListener(ApplicationReadyEvent.class)
    public void loadDataFromCsv() throws IOException, CsvValidationException, ParseException {
        CSVReader csvReader = new CSVReader(new FileReader(Objects.requireNonNull(this.getClass().getResource("/user.csv")).getFile()));
        csvReader.skip(1);
        String[] csvCell;
        List<UserDTO> userDTOList = new ArrayList<UserDTO>();
        while ((csvCell = csvReader.readNext()) != null && csvCell.length > 1) {
            String name = csvCell[0];
            String firstName = csvCell[1];
            String memberSince = csvCell[2];
            String memberTill = csvCell[3];
            String gender = csvCell[4];
            List<BorrowDTO> borrows = new ArrayList<BorrowDTO>();
            userDTOList.add(UserDTO.builder()
                    .borrows(borrows)
                    .firstName(firstName)
                    .lastName(name)
                    .membershipFrom(DateUtils.getInstantFromString(memberSince))
                    .membershipTo(DateUtils.getInstantFromString(memberTill))
                    .gender(GenderDTO.valueOf(gender))
                    .build());
        }
        fillBookDTOs();
        bookService.save(new ArrayList<>(bookDTOs));
        fillBorrowDTOs(userDTOList);
        userService.save(userDTOList);
    }

    public void fillBorrowDTOs(List<UserDTO> userDTOList) throws IOException, CsvValidationException, ParseException {
        String[] csvCell;
        CSVReader csvReader = new CSVReader(new FileReader(Objects.requireNonNull(this.getClass().getResource("/borrowed.csv")).getFile()));
        csvReader.skip(1);
        while ((csvCell = csvReader.readNext()) != null && csvCell.length > 1) {
            String fullName = csvCell[0];
            UserDTO userDTO = userDTOList.stream().filter(u -> (u.getLastName() + "," + u.getFirstName()).equals(fullName)).findFirst().orElse(null);
            if (userDTO != null) {
                String bookName = csvCell[1];
                String fromDate = csvCell[2];
                String toDate = csvCell[3];
                BookDTO bookDTO = bookService.find(BookDTO.builder().name(bookName).build()).orElse(null);
                BorrowDTO borrowDTO = BorrowDTO.builder()
                        .from(DateUtils.getInstantFromString(fromDate))
                        .to(DateUtils.getInstantFromString(toDate))
                        .book(bookDTO)
                        .build();
                userDTO.getBorrows().add(borrowDTO);
            }
        }
    }

    public void fillBookDTOs() throws IOException, CsvValidationException {
        CSVReader csvReader = new CSVReader(new FileReader(Objects.requireNonNull(this.getClass().getResource("/books.csv")).getFile()));
        csvReader.skip(1);
        String[] csvCell;
        while ((csvCell = csvReader.readNext()) != null && csvCell.length > 1) {
            String title = csvCell[0];
            String author = csvCell[1];
            String genre = csvCell[2];
            String publisher = csvCell[3];
            if (!(title.isEmpty() && author.isEmpty() && genre.isEmpty() && publisher.isEmpty()) &&
                    bookDTOs.stream().noneMatch(b -> b.getName().equals(title) && b.getBookAuthor().equals(author)
                    && b.getBookGenre().equals(genre) && b.getBookPublisher().equals(publisher))) {
                BookDTO bookDTO = BookDTO.builder()
                        .name(title)
                        .bookAuthor(author)
                        .bookGenre(genre)
                        .bookPublisher(publisher)
                        .build();
                bookDTOs.add(bookDTO);
            }
        }
    }
}