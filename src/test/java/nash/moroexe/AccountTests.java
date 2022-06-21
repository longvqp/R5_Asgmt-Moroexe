package nash.moroexe;

import nash.moroexe.controlers.rest.AccountController;
import nash.moroexe.services.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

@WebMvcTest(AccountController.class)
public class AccountTests {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private AccountService accountService;

    @Test
    public void AccountAPI_shouldConnect_whenPing() throws Exception{
        when(accountService.ping()).thenReturn("Account Service is Up");

        this.mockMvc.perform(get("/test")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Account Service is Up")));;
    }
}
