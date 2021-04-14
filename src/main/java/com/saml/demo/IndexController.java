package com.saml.demo;

import java.util.List;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

  @RequestMapping("/")
  public String index(ExpiringUsernameAuthenticationToken userToken, Model model) {

    SAMLCredential samlCredential = (SAMLCredential) userToken.getCredentials();

    List<org.opensaml.saml2.core.Attribute> as = samlCredential.getAttributes();
    for (org.opensaml.saml2.core.Attribute attribute : as) {
      if ("userFirstName".equals(attribute.getName())) {
        model.addAttribute("firstName", samlCredential.getAttributeAsString(attribute.getName()));
      }
      System.out.println(
          attribute.getName() + "->" + samlCredential.getAttributeAsString(attribute.getName()));
    }

    return "index";
  }
}