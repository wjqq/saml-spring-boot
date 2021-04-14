# saml-spring-boot






### - refer to : https://www.youtube.com/watch?v=ATdCwJXMsAQ

###  - my okta app on okta. (account: wj21067855@gmail.com)
https://dev-29281223.okta.com/app/exkl01qupN298GybC5d6/sso/saml/metadata

###  - setting steps by steps
https://developer.okta.com/blog/2017/03/16/spring-boot-saml


###  Get user info from saml TOKEN
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
