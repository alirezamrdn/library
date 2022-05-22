package io.example.library.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs
@WebMvcTest(UserResource.class)
public class UserResourceTest {
    private AppInitializer appInitializer;
    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void findAtLeastOneBookBorrowers() throws Exception{
        mockMvc.perform(get(UrlConstants.GLOBAL_URL + UrlConstants.AT_LEAST_ONE_BOOK_BORROWERS))
                .andExpect(status().isOk()).andDo(
                        r -> System.out.println(r.getResponse().getContentAsString()));
    }
}
