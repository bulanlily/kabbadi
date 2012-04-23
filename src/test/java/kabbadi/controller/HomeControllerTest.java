package kabbadi.controller;

import kabbadi.service.UserService;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {

   @Test
    public void should_redirect_to_invoice_list() {
       UserService mockUserService = Mockito.mock(UserService.class);
       assertThat(new HomeController(mockUserService).homepage(), equalTo("redirect:/invoice/list"));
   }
}
