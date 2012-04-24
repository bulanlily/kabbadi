package kabbadi.controller;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class HomeControllerTest {

   @Test
    public void should_redirect_to_invoice_list() {
       assertThat(new HomeController().homepage(), equalTo("redirect:/invoice/list"));
   }
}
