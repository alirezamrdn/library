package io.example.library.web.rest;

import io.example.library.AppInitializer;
import io.example.library.service.UserService;
import io.example.library.web.util.UrlConstants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(BorrowResource.class)
public class UserResourceTest {
    @MockBean
    UserService userService;

    @MockBean
    AppInitializer appInitializer;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testServices() throws Exception {
        appInitializer.loadDataFromCsv();
        given(appInitializer).will(a -> {
            mockMvc.perform(get(UrlConstants.GLOBAL_BORROW_URL + UrlConstants.BORROWER__AT_LEAST_ONE_BOOK_BORROWERS))
                    .andExpect(status().isOk()).andDo(
                            r -> System.out.println(r.getResponse().getContentAsString()));
            mockMvc.perform(get(UrlConstants.GLOBAL_BORROW_URL + UrlConstants.BORROWER__NON_TERMINATED_USERS_WITHOUT_BORROWING))
                    .andExpect(status().isOk()).andDo(
                            r -> System.out.println(r.getResponse().getContentAsString()));
            return null;
        });

    }
}
