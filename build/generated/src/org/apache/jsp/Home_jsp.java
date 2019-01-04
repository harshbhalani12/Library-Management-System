package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/style.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/font-awesome.min.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/font_awesome.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/feedbackstyle.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/fwslider.css\" media=\"all\">\n");
      out.write("        <script src=\"js/jquery-ui.min.js\"></script>\n");
      out.write("        <script src=\"js/fwslider.js\"></script>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\".dropdown img.flag\").addClass(\"flagvisibility\");\n");
      out.write("\n");
      out.write("                $(\".dropdown dt a\").click(function () {\n");
      out.write("                    $(\".dropdown dd ul\").toggle();\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                $(\".dropdown dd ul li a\").click(function () {\n");
      out.write("                    var text = $(this).html();\n");
      out.write("                    $(\".dropdown dt a span\").html(text);\n");
      out.write("                    $(\".dropdown dd ul\").hide();\n");
      out.write("                    $(\"#result\").html(\"Selected value is: \" + getSelectedValue(\"sample\"));\n");
      out.write("                });\n");
      out.write("\n");
      out.write("                function getSelectedValue(id) {\n");
      out.write("                    return $(\"#\" + id).find(\"dt a span.value\").html();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("                $(document).bind('click', function (e) {\n");
      out.write("                    var $clicked = $(e.target);\n");
      out.write("                    if (!$clicked.parents().hasClass(\"dropdown\"))\n");
      out.write("                        $(\".dropdown dd ul\").hide();\n");
      out.write("                });\n");
      out.write("\n");
      out.write("\n");
      out.write("                $(\"#flagSwitcher\").click(function () {\n");
      out.write("                    $(\".dropdown img.flag\").toggleClass(\"flagvisibility\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("            .modal {\n");
      out.write("                display:hidden; /* Hidden by default */\n");
      out.write("                position: fixed; /* Stay in place */\n");
      out.write("                z-index: 100000;/*sit on top */\n");
      out.write("                left: 0;\n");
      out.write("                top: 0;\n");
      out.write("                width: 100%; /* Full width */\n");
      out.write("                height: 100%; /* Full height */\n");
      out.write("                overflow: auto; /* Enable scroll if needed */\n");
      out.write("                background-color: rgb(0,0,0); /* Fallback color */\n");
      out.write("                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */\n");
      out.write("            }\n");
      out.write("            .modal-content {\n");
      out.write("                background-color: #fefefe;\n");
      out.write("                margin: 15% auto; /* 15% from the top and centered */\n");
      out.write("                padding: 20px;\n");
      out.write("                border: 1px solid #888;\n");
      out.write("                width: 80%; /* Could be more or less, depending on screen size */\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- ................header starts....................... -->\n");
      out.write("        ");
      out.write("<div class=\"header\">\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"header-left\">\n");
      out.write("<!--                    <div class=\"logo\">\n");
      out.write("                        <a href=\"home.jsp\"><img src=\"images/logo.png\" alt=\"\"/></a>\n");
      out.write("                    </div>-->\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <a class=\"toggleMenu\" href=\"#\"><img src=\"images/nav.png\" alt=\"\" /></a>\n");
      out.write("                        <ul class=\"nav\" id=\"nav\">\n");
      out.write("                            <!--\n");
      out.write("                            <li><a href=\"shop.html\">Shop</a></li>\n");
      out.write("                            <li><a href=\"team.html\">Team</a></li>\n");
      out.write("                            <li><a href=\"shop.html\">Events</a></li>\n");
      out.write("                            <li><a href=\"experiance.html\">Experiance</a></li>\n");
      out.write("                            <li><a href=\"shop.html\">Company</a></li>\n");
      out.write("                            <li><a href=\"contact.html\">Contact</a></li>\t\t\t\t\t\t\t\t\n");
      out.write("                            -->\n");
      out.write("                            <li><a href=\"ElectronicsServlet\">Electronics</a></li>\n");
      out.write("                            <li><a href=\"#\">Home</a></li>\n");
      out.write("                            <li><a href=\"FashionServlet\">Fashion</a></li>\n");
      out.write("                            <li><a href=\"#\">Company</a></li>\n");
      out.write("                            <li><a href=\"contact.jsp\">Contact</a></li>\n");
      out.write("                            <li><a href=\"Login.jsp\">Login</a></li>\n");
      out.write("                            \n");
      out.write("                            <div class=\"clear\"></div>\n");
      out.write("                        </ul>\n");
      out.write("                        <script type=\"text/javascript\" src=\"js/responsive-nav.js\"></script>\n");
      out.write("                    </div>\t\t\t\t\t\t\t\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header_right\">\n");
      out.write("                    <!-- start search-->\n");
      out.write("                    <div class=\"search-box\">\n");
      out.write("                        <div id=\"sb-search\" class=\"sb-search\">\n");
      out.write("                            <form>\n");
      out.write("                                <input class=\"sb-search-input\" placeholder=\"Enter your search term...\" type=\"search\" name=\"search\" id=\"search\">\n");
      out.write("                                <input class=\"sb-search-submit\" type=\"submit\" value=\"\">\n");
      out.write("                                <span class=\"sb-icon-search\"> </span>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!----search-scripts---->\n");
      out.write("                    \n");
      out.write("                    <script src=\"js/classie.js\"></script>\n");
      out.write("                    <script src=\"js/uisearch.js\"></script>\n");
      out.write("                    \n");
      out.write("                    <script>\n");
      out.write("                        new UISearch( document.getElementById( 'sb-search' ) );\n");
      out.write("                    </script>\n");
      out.write("                    <ul class=\"icon1 sub-icon1 profile_img\">\n");
      out.write("                        <li><!--<a class=\"active-icon \" href=\"#\"> </a>-->\n");
      out.write("                            <a class=\"fa fa-shopping-cart\" href=\"CartServlet\" id=\"cart\"> </a>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("<!--                            <ul class=\"sub-icon1 list\" style=\"height: 100px;\">\n");
      out.write("                                <div class=\"product_control_buttons\">\n");
      out.write("                                    <a href=\"#\"><img src=\"images/edit.png\" alt=\"\"/></a>\n");
      out.write("                                    <a href=\"#\"><img src=\"images/close_edit.png\" alt=\"\"/></a>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"clear\"></div>\n");
      out.write("                                <li class=\"list_img\"><img src=\"images/1.jpg\" alt=\"\"/></li>\n");
      out.write("                                <li class=\"list_desc\"><h4><a href=\"#\">velit esse molestie</a></h4><span class=\"actual\">1 x\n");
      out.write("                                        $12.00</span></li>\n");
      out.write("                                <div class=\"login_buttons\">\n");
      out.write("                                    <div class=\"check_button\"><a href=\"CartServlet\">Check out</a></div>\n");
      out.write("                                    <div class=\"login_button\"><a href=\"Login.jsp\">Login</a></div>\n");
      out.write("                                    <div class=\"clear\"></div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"clear\"></div>\n");
      out.write("                            </ul>-->\n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"float: right;margin-right: 150px; z-index: 100;\">\n");
      out.write("    <a href=\"Login.jsp\" style=\"background: #000; color: #fff; padding: 5px 15px; border-radius: 5px\">Login</a>\n");
      out.write("    <a href=\"Logout.jsp\" id=\"logoutId\" style=\"background: #000; color: #fff; padding: 5px 15px; border-radius: 5px;\" >LogOut</a>\n");
      out.write("</div>\n");
      out.write(" \n");
      out.write("        <!-- ................header ends   ....................... -->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"banner\">\n");
      out.write("            <!-- start slider -->\n");
      out.write("            <div id=\"fwslider\">\n");
      out.write("                <div class=\"slider_container\">\n");
      out.write("                    <div class=\"slide\"> \n");
      out.write("                        <!-- Slide image -->\n");
      out.write("                        <img src=\"images/slider1.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                        <!-- /Slide image -->\n");
      out.write("                        <!-- Texts container -->\n");
      out.write("                        <div class=\"slide_content\">\n");
      out.write("                            <div class=\"slide_content_wrap\">\n");
      out.write("                                <!-- Text title -->\n");
      out.write("                                <h1 class=\"title\">Run Over<br>Everything</h1>\n");
      out.write("                                <!-- /Text title -->\n");
      out.write("                                <div class=\"button\"><a href=\"#\">See Details</a></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /Texts container -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /Duplicate to create more slides -->\n");
      out.write("                    <div class=\"slide\">\n");
      out.write("                        <img src=\"images/slider2.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                        <div class=\"slide_content\">\n");
      out.write("                            <div class=\"slide_content_wrap\">\n");
      out.write("                                <h1 class=\"title\">Run Over<br>Everything</h1>\n");
      out.write("                                <div class=\"button\"><a href=\"#\">See Details</a></div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!--/slide -->\n");
      out.write("                </div>\n");
      out.write("                <div class=\"timers\"></div>\n");
      out.write("                <div class=\"slidePrev\"><span></span></div>\n");
      out.write("                <div class=\"slideNext\"><span></span></div>\n");
      out.write("            </div>\n");
      out.write("            <!--/slider -->\n");
      out.write("        </div>\n");
      out.write("        <div class=\"main\">\n");
      out.write("            <div class=\"content-top\">\n");
      out.write("                <h2>snowboards</h2>\n");
      out.write("                <p>hendrerit in vulputate velit esse molestie consequat, vel illum dolore</p>\n");
      out.write("                <div class=\"close_but\"><i class=\"close1\"> </i></div>\n");
      out.write("                <ul id=\"flexiselDemo3\">\n");
      out.write("                    <li><img src=\"images/board1.jpg\" /></li>\n");
      out.write("                    <li><img src=\"images/board2.jpg\" /></li>\n");
      out.write("                    <li><img src=\"images/board3.jpg\" /></li>\n");
      out.write("                    <li><img src=\"images/board4.jpg\" /></li>\n");
      out.write("                    <li><img src=\"images/board5.jpg\" /></li>\n");
      out.write("                </ul>\n");
      out.write("                <h3>SnowBoard Extreme Series</h3>\n");
      out.write("                <script type=\"text/javascript\">\n");
      out.write("                    $(window).load(function () {\n");
      out.write("                        $(\"#flexiselDemo3\").flexisel({\n");
      out.write("                            visibleItems: 5,\n");
      out.write("                            animationSpeed: 1000,\n");
      out.write("                            autoPlay: true,\n");
      out.write("                            autoPlaySpeed: 3000,\n");
      out.write("                            pauseOnHover: true,\n");
      out.write("                            enableResponsiveBreakpoints: true,\n");
      out.write("                            responsiveBreakpoints: {\n");
      out.write("                                portrait: {\n");
      out.write("                                    changePoint: 480,\n");
      out.write("                                    visibleItems: 1\n");
      out.write("                                },\n");
      out.write("                                landscape: {\n");
      out.write("                                    changePoint: 640,\n");
      out.write("                                    visibleItems: 2\n");
      out.write("                                },\n");
      out.write("                                tablet: {\n");
      out.write("                                    changePoint: 768,\n");
      out.write("                                    visibleItems: 3\n");
      out.write("                                }\n");
      out.write("                            }\n");
      out.write("                        });\n");
      out.write("\n");
      out.write("                    });\n");
      out.write("                </script>\n");
      out.write("                <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"content-bottom\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row content_bottom-text\">\n");
      out.write("                    <div class=\"col-md-7\">\n");
      out.write("                        <h3>The Mountains<br>Snowboarding</h3>\n");
      out.write("                        <p class=\"m_1\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio.</p>\n");
      out.write("                        <p class=\"m_2\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio.</p>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"features\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <h3 class=\"m_3\">Features</h3>\n");
      out.write("                <div class=\"close_but\"><i class=\"close1\"> </i></div>\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3 top_box\">\n");
      out.write("                        <div class=\"view view-ninth\"><a href=\"single.html\">\n");
      out.write("                                <img src=\"images/pic1.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                                <div class=\"mask mask-1\"> </div>\n");
      out.write("                                <div class=\"mask mask-2\"> </div>\n");
      out.write("                                <div class=\"content\">\n");
      out.write("                                    <h2>Hover Style #9</h2>\n");
      out.write("                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>\n");
      out.write("                                </div>\n");
      out.write("                            </a> </div\n");
      out.write("                    </div>\n");
      out.write("                    <h4 class=\"m_4\"><a href=\"#\">nostrud exerci ullamcorper</a></h4>\n");
      out.write("                    <p class=\"m_5\">claritatem insitam</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 top_box\">\n");
      out.write("                    <div class=\"view view-ninth\"><a href=\"single.html\">\n");
      out.write("                            <img src=\"images/pic2.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                            <div class=\"mask mask-1\"> </div>\n");
      out.write("                            <div class=\"mask mask-2\"> </div>\n");
      out.write("                            <div class=\"content\">\n");
      out.write("                                <h2>Hover Style #9</h2>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <h4 class=\"m_4\"><a href=\"#\">nostrud exerci ullamcorper</a></h4>\n");
      out.write("                    <p class=\"m_5\">claritatem insitam</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 top_box\">\n");
      out.write("                    <div class=\"view view-ninth\"><a href=\"single.html\">\n");
      out.write("                            <img src=\"images/pic3.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                            <div class=\"mask mask-1\"> </div>\n");
      out.write("                            <div class=\"mask mask-2\"> </div>\n");
      out.write("                            <div class=\"content\">\n");
      out.write("                                <h2>Hover Style #9</h2>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <h4 class=\"m_4\"><a href=\"#\">nostrud exerci ullamcorper</a></h4>\n");
      out.write("                    <p class=\"m_5\">claritatem insitam</p>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-3 top_box1\">\n");
      out.write("                    <div class=\"view view-ninth\"><a href=\"single.html\">\n");
      out.write("                            <img src=\"images/pic4.jpg\" class=\"img-responsive\" alt=\"\"/>\n");
      out.write("                            <div class=\"mask mask-1\"> </div>\n");
      out.write("                            <div class=\"mask mask-2\"> </div>\n");
      out.write("                            <div class=\"content\">\n");
      out.write("                                <h2>Hover Style #9</h2>\n");
      out.write("                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </a> </div>\n");
      out.write("                    <h4 class=\"m_4\"><a href=\"#\">nostrud exerci ullamcorper</a></h4>\n");
      out.write("                    <p class=\"m_5\">claritatem insitam</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!-- <div class=\"main\">\n");
      out.write("         <div class=\"shop_top\">\n");
      out.write("             <div class=\"container\">\n");
      out.write("                 <div class=\"col-md-6\">\n");
      out.write("                     <div class=\"login-page\">\n");
      out.write("                         <h4 class=\"title\">New Customers</h4>\n");
      out.write("                         <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis</p>\n");
      out.write("                         <div class=\"button1\">\n");
      out.write("                             <a href=\"Register.jsp\"><input type=\"submit\" name=\"Submit\" value=\"Create an Account\"></a>\n");
      out.write("                         </div>\n");
      out.write("                         <div class=\"clear\"></div>\n");
      out.write("                     </div>\n");
      out.write("                 </div>\n");
      out.write("                 <div class=\"col-md-6\">\n");
      out.write("                     <div class=\"login-title\">\n");
      out.write("                         <h4 class=\"title\">Registered Customers</h4>\n");
      out.write("                         <div id=\"loginbox\" class=\"loginbox\">\n");
      out.write("                             <form action=\"LoginServlet\" name=\"login\" id=\"login-form\">\n");
      out.write("                                 <fieldset class=\"input\">\n");
      out.write("                                     <p id=\"login-form-username\">\n");
      out.write("                                         <label for=\"modlgn_username\">Email</label>\n");
      out.write("                                         <input id=\"modlgn_username\" type=\"text\" name=\"email\" class=\"inputbox\" size=\"18\">\n");
      out.write("                                     </p>\n");
      out.write("                                     <p id=\"login-form-password\">\n");
      out.write("                                         <label for=\"modlgn_passwd\">Password</label>\n");
      out.write("                                         <input id=\"modlgn_passwd\" type=\"text\" name=\"password\" class=\"inputbox\" size=\"18\">\n");
      out.write("                                     </p>\n");
      out.write("                                     <div class=\"remember\">\n");
      out.write("                                         <p id=\"login-form-remember\">\n");
      out.write("                                             <label for=\"modlgn_remember\"><a href=\"#\">Forget Your Password ? </a></label>\n");
      out.write("                                         </p>\n");
      out.write("                                         <input type=\"submit\" class=\"button\" value=\"Login\"><div class=\"clear\"></div>\n");
      out.write("                                     </div>\n");
      out.write("                                 </fieldset>\n");
      out.write("                             </form>\n");
      out.write("                         </div>\n");
      out.write("                     </div>\n");
      out.write("                     <div class=\"clear\"></div>\n");
      out.write("                 </div>\n");
      out.write("             </div>\n");
      out.write("         </div>\n");
      out.write("     </div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("    <!-- ...........footer goes here.................... -->\n");
      out.write("    ");
      out.write("\n");
      out.write("    <!--............ footer ends........................ -->\n");
      out.write("    <div>\n");
      out.write("      \n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
