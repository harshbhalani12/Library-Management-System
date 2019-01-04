package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.FineDetails;
import java.util.ArrayList;
import model.Borrower;

public final class CheckFines_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/AdminHeader.jsp");
    _jspx_dependants.add("/AdminVerticalHeader.jsp");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Check Fines Page</title>\n");
      out.write("        <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/bootstrap.min.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/style_1.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <link href=\"css/font_awesome.css\" rel='stylesheet' type='text/css' />\n");
      out.write("        <link href=\"css/adminheadercss.css\" rel='stylesheet' type='text/css' />\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>\n");
      out.write("        <script type=\"application/x-javascript\"> addEventListener(\"load\", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>\n");
      out.write("        <script src=\"js/jquery.min.js\"></script>\n");
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
      out.write("\n");
      out.write("        <style>\n");
      out.write("            @keyframes burst{\n");
      out.write("                0%{\n");
      out.write("                    opacity:.6;\n");
      out.write("                }\n");
      out.write("                50%{\n");
      out.write("                    transform: scale(2.5);\n");
      out.write("                    opacity: 0;\n");
      out.write("                }\n");
      out.write("                100%{\n");
      out.write("                    opacity: 0;\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .user:hover .faa-burst.animated{\n");
      out.write("                animation: burst 3s infinite linear;\n");
      out.write("            }\n");
      out.write("            .usergroup:hover .faa-burst.animated{\n");
      out.write("                animation: burst 3s infinite linear;\n");
      out.write("            }\n");
      out.write("            .shoppingcart:hover .faa-burst.animated{\n");
      out.write("                animation: burst 3s infinite linear;\n");
      out.write("            }\n");
      out.write("            .visitors:hover .faa-burst.animated{\n");
      out.write("                animation: burst 3s infinite linear;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                //alert(0);\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'GetDataForAdmin',\n");
      out.write("                    success: function (data) {\n");
      out.write("                        //alert(data);\n");
      out.write("                        var list = $.parseJSON(data);\n");
      out.write("                        //alert(list);\n");
      out.write("                        $('#totalUser').html(list[0]);\n");
      out.write("                        $('#newUser').html(list[1]);\n");
      out.write("\n");
      out.write("                        $('#totalUsers').html(list[0]);\n");
      out.write("                        $('#newUsers').html(list[1]);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- ADMIN HEADER STARTS -->\n");
      out.write("        ");
      out.write("<script>\n");
      out.write("    $(document).ready(function(){\n");
      out.write("       //alert(\"admin link alert\");\n");
      out.write("       $.ajax({\n");
      out.write("           \n");
      out.write("           type: \"POST\",\n");
      out.write("           url:'GetSPRequestForAdmin',\n");
      out.write("           success:function(data){\n");
      out.write("               $('#messages').html(data);\n");
      out.write("           }\n");
      out.write("       });\n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<div class=\"header\" style=\"height: 70px; padding:0.5% 0;\">\n");
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <div class=\"header-left\">\n");
      out.write("                    <div class=\"logo\">\n");
      out.write("                        <!--<a href=\"index.html\"><img src=\"images/logo.png\" alt=\"\"/></a>-->\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <a class=\"toggleMenu\" href=\"#\"><img src=\"images/nav.png\" alt=\"\" /></a>\n");
      out.write("\n");
      out.write("                        <ul class=\"\" id=\"\">\n");
      out.write("\n");
      out.write("                            <li class=\"dropdown\">\n");
      out.write("                                <a href=\"MessagesServlet1\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                    <i class=\"fa fa-envelope\"></i>\n");
      out.write("                                    <span class=\"badge\" id=\"messages\">0</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown head-dpdn\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                    <i class=\"fa fa-bell\"></i>\n");
      out.write("                                    <span class=\"badge\">0</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"dropdown head-dpdn\">\n");
      out.write("                                <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                    <i class=\"fa fa-tasks\"></i>\n");
      out.write("                                    <span class=\"badge\">0</span>\n");
      out.write("                                </a>\n");
      out.write("                            </li>\n");
      out.write("                            <div class=\"clear\"></div>\n");
      out.write("                        </ul>\n");
      out.write("                        <script type=\"text/javascript\" src=\"js/responsive-nav.js\"></script>\n");
      out.write("                        <!--\n");
      out.write("                        <ul class=\"\" id=\"\" style=\"margin:0;\">\n");
      out.write("                        <!--\n");
      out.write("                        <li><a href=\"#\">Electronics</a></li>\n");
      out.write("                        <li><a href=\"#\">Home</a></li>\n");
      out.write("                        <div class=\"clear\"></div>\n");
      out.write("                        -->\n");
      out.write("                        <!--\n");
      out.write("                        <li class=\"dropdown\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                <i class=\"fa fa-envelope\"></i>\n");
      out.write("                                <span class=\"badge\">3</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <ul class=\"dropdown-menu\">\n");
      out.write("                            <li>\n");
      out.write("\n");
      out.write("                                <div class=\"notification-header\">\n");
      out.write("                                    You have 3 new Notifications\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                        <li class=\"dropdown head-dpdn\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                <i class=\"fa fa-bell\"></i>\n");
      out.write("                                <span class=\"badge\">2</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"dropdown head-dpdn\">\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" area-exapanded=\"false\">\n");
      out.write("                                <i class=\"fa fa-tasks\"></i>\n");
      out.write("                                <span class=\"badge\">3</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                        -->\n");
      out.write("                        <script type=\"text/javascript\" src=\"js/responsive-nav.js\"></script>\n");
      out.write("                    </div>\t\t\t\t\t\t\t\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- start search-->\n");
      out.write("\n");
      out.write("                    <div id=\"sb-search\" class=\"sb-search sb-search-open\" style=\"float:left;\">\n");
      out.write("                        <form>\n");
      out.write("                            <input class=\"sb-search-input\" placeholder=\"Enter your search term...\" type=\"search\" name=\"search\" id=\"search\">\n");
      out.write("                            <input class=\"sb-search-submit\" type=\"submit\" value=\"\">\n");
      out.write("                            <span class=\"sb-icon-search\"> </span>\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!----search-scripts---->\n");
      out.write("\n");
      out.write("                    <script src=\"js/classie.js\"></script>\n");
      out.write("                    <script src=\"js/uisearch.js\"></script>\n");
      out.write("\n");
      out.write("                    <script>\n");
      out.write("                        new UISearch(document.getElementById('sb-search'));\n");
      out.write("                    </script>\n");
      out.write("\n");
      out.write("                    <div class=\"clear\"></div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"header_right\">\n");
      out.write("                    <!-- \n");
      out.write("                     <ul class=\"icon1 sub-icon1 profile_img\">\n");
      out.write("                         <li><a class=\"active-icon c1\" href=\"#\"> </a>\n");
      out.write("                             <ul class=\"sub-icon1 list\">\n");
      out.write("                                 <div class=\"product_control_buttons\">\n");
      out.write("                                     <a href=\"#\"><img src=\"images/edit.png\" alt=\"\"/></a>\n");
      out.write("                                     <a href=\"#\"><img src=\"images/close_edit.png\" alt=\"\"/></a>\n");
      out.write("                                 </div>\n");
      out.write("                                 <div class=\"clear\"></div>\n");
      out.write("                                 <li class=\"list_img\"><img src=\"images/1.jpg\" alt=\"\"/></li>\n");
      out.write("                                 <li class=\"list_desc\"><h4><a href=\"#\">velit esse molestie</a></h4><span class=\"actual\">1 x\n");
      out.write("                                         $12.00</span></li>\n");
      out.write("                                 <div class=\"login_buttons\">\n");
      out.write("                                     <div class=\"check_button\"><a href=\"checkout.html\">Check out</a></div>\n");
      out.write("                                     <div class=\"login_button\"><a href=\"Login.jsp\">Login</a></div>\n");
      out.write("                                     <div class=\"clear\"></div>\n");
      out.write("                                 </div>\n");
      out.write("                                 <div class=\"clear\"></div>\n");
      out.write("                             </ul>\n");
      out.write("                         </li>\n");
      out.write("                     </ul>\n");
      out.write("                     <div class=\"clear\"></div>\n");
      out.write("                    -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<div style=\"float: right;margin-right: 150px; z-index: 100;\">\n");
      out.write("<!--    <a href=\"Login.jsp\" style=\"background: #000; color: #fff; padding: 5px 15px; border-radius: 5px\">Login</a>-->\n");
      out.write("    <a href=\"Logout.jsp\" id=\"logoutId\" style=\"background: #000; color: #fff; padding: 5px 15px; border-radius: 5px;\" >LogOut</a>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<!--<div class=\"side-nav\">\n");
      out.write("    <nav>\n");
      out.write("        <ul>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"AdminPage.jsp\"> \n");
      out.write("                    <span> <i class=\"fa fa-user\"></i></span>\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("\n");
      out.write("            <li>\n");
      out.write("                <a href=\"#\">\n");
      out.write("                    <span><i class=\"fa fa-envelope\"></i></span>\n");
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("            <li class=\"active\">\n");
      out.write("                <a href=\"#\">\n");
      out.write("                    <span><i class=\"fa fa-bar-chart\"></i></span>\n");
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <a href=\"FeedbackShowServlet\">\n");
      out.write("                    <span><i class=\"fa fa-credit-card-alt\"></i></span>\n");
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("    </nav>\n");
      out.write("</div>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- ADMIN HEADER STARTS -->\n");
      out.write("        <!--....................ADMIN PAGE CONTENT.................. -->\n");
      out.write("        <section id=\"main\" style=\"padding: 2em;\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-3\">\n");
      out.write("                        <div class=\"list-group\">\n");
      out.write("                            ");
      out.write("\n");
      out.write("<script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                //alert(0);\n");
      out.write("                $.ajax({\n");
      out.write("                    url: 'GetDataForAdmin',\n");
      out.write("                    success:function(data){\n");
      out.write("                        //alert(data);\n");
      out.write("                        var list = $.parseJSON(data);\n");
      out.write("                        //alert(list);\n");
      out.write("                        $('#totalUser').html(list[0]);\n");
      out.write("                        $('#newUser').html(list[1]);\n");
      out.write("                        $('#serviceProvider').html(list[2]);\n");
      out.write("                        \n");
      out.write("                        $('#totalUsers').html(list[0]);\n");
      out.write("                        $('#newUsers').html(list[1]);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("        <a href=\"#\" class=\"list-group-item active main-color-bg\">\n");
      out.write("    <span class=\"fa fa-user-circle\" aria-hidden=\"true\"></span> Welcome Harsh <span>\n");
      out.write("        <a href=\"Logout.jsp\"><i class=\"fa fa-power-off pull-right\"></i></a>\n");
      out.write("    </span>\n");
      out.write("</a>\n");
      out.write("<a href=\"\" class=\"list-group-item\">\n");
      out.write("    <span class=\"fa fa-group\" aria-hidden=\"true\"></span>\n");
      out.write("    <span style=\"padding:5px;\">Total Users</span> \n");
      out.write("    <span class=\"badge\" id=\"totalUser\">0</span>\n");
      out.write("</a>\n");
      out.write("<a href=\"AddBorrower.jsp\" class=\"list-group-item\">\n");
      out.write("    <span class=\"fa fa-plus\" aria-hidden=\"true\"></span>\n");
      out.write("    <span style=\"padding:0px;\"> Add New Borrower</span>\n");
      out.write("    <span class=\"badge\"><span> > </span></span></a>\n");
      out.write("<a href=\"ManageBooks.jsp\" class=\"list-group-item\">\n");
      out.write("    <span class=\"fa fa-group\" aria-hidden=\"true\"></span>\n");
      out.write("        <span style=\"padding:0px;\"> Manage Books</span>  \n");
      out.write("    <span class=\"badge\" id=\"newUser\"><span> > </span></span>\n");
      out.write("</a>\n");
      out.write("<a href=\"CheckFines.jsp\" class=\"list-group-item\">\n");
      out.write("    <span class=\"fa fa-shopping-cart\" aria-hidden=\"true\"></span> Check Fines\n");
      out.write("    <span class=\"badge\" id=\"serviceProvider\"><span> > </span></span>\n");
      out.write("   \n");
      out.write("</a>");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"well\" style=\"padding:0;\">\n");
      out.write("                            <canvas id=\"canvas\" width=\"500\" height=\"500\" style=\"display: none;\"></canvas>\n");
      out.write("                            <img id=\"myImage\" width=\"260\" height=\"260\"/>\n");
      out.write("\n");
      out.write("                            <script src=\"js/clock.js\"></script>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-9\">\n");
      out.write("                        <!-- Website Overview -->\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading main-color-bg\">\n");
      out.write("                                <h3 class=\"panel-title\">Fines</h3>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <table class=\"table table-striped\">\n");
      out.write("                                    ");

                                        if (request.getAttribute("msg") != null) {
                                    
      out.write("\n");
      out.write("                                    <tr>");
      out.print(request.getAttribute("msg"));
      out.write("</tr>\n");
      out.write("                                    ");

                                        }
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>\n");
      out.write("                                            Please Click on the Update button to update all fines.\n");
      out.write("                                        </th>\n");
      out.write("                                        <th>\n");
      out.write("                                            <a href=\"UpdateAllFines\" class=\"btn btn-danger\">Update Fines</a>\n");
      out.write("                                        </th>\n");
      out.write("\n");
      out.write("                                    </tr>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td><form action=\"ListAllFineServlet\"><input type=\"submit\" value=\"List all entries\" class=\"btn btn-info\"></form></td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table> \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <table class=\"table table-striped table-hover\" id=\"table\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            <form action=\"CheckFineForBorrowerServlet\">\n");
      out.write("                                                <label>Card No:</label>\n");
      out.write("                                                <input type=\"text\" class=\"form-group\" name=\"CardNo\" style=\"margin-left:10px;\">\n");
      out.write("                                                <!--<input type=\"hidden\" name=\"Isbn10\" value=\"");
//request.getAttribute("Isbn10")
      out.write("\">-->\n");
      out.write("                                                <input type=\"submit\" value=\"Search\" class=\"btn btn-primary\">\n");
      out.write("                                            </form>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>\n");
      out.write("                                            ");

                                                if (request.getAttribute("msg") != null) {
                                            
      out.write("\n");
      out.write("                                            ");
      out.print(request.getAttribute("msg"));
      out.write("\n");
      out.write("                                            ");

                                                }
                                            
      out.write("\n");
      out.write("\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("\n");
      out.write("                                ");

                                    if (request.getAttribute("list") != null) {
                                        ArrayList<FineDetails> al = (ArrayList<FineDetails>) request.getAttribute("list");
                                
      out.write("\n");
      out.write("                                <form action='PayFineServlet'>\n");
      out.write("                                    <table class=\"table table-striped table-hover\">\n");
      out.write("                                        <tr>\n");
      out.write("                                            <th>Card Id</th>\n");
      out.write("                                            <th>First Name</th>\n");
      out.write("                                            <th>Last Name</th>\n");
      out.write("                                            <th>Fine Due</th>\n");
      out.write("                                            <!--<th>hello</th>-->\n");
      out.write("                                            <!--<th>Amount Pay</th>-->\n");
      out.write("                                            <th></th>\n");
      out.write("                                        </tr>\n");
      out.write("                                        ");

                                            for (int i = 0; i < al.size(); i++) {
                                                FineDetails b = al.get(i);
                                        
      out.write("\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>");
      out.print(b.getCardId());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(b.getFirstName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(b.getLastName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(b.getFine());
      out.write("</td>\n");
      out.write("                                            <!--<td>");
//b.getLoanId()
      out.write("</td>-->\n");
      out.write("                                        <input type=\"text\" value=\"");
      out.print(b.getLoanId());
      out.write("\" name=\"loanId\" hidden=\"true\">\n");
      out.write("                                        <input type=\"text\" value=\"");
      out.print(b.getCardId());
      out.write("\" name=\"CardId\" hidden=\"true\">\n");
      out.write("                                        <!--<td><input type=\"text\" value=\"\" name=\"FineAmtToPay\" class=\"form-group\"></td>-->\n");
      out.write("                                        <td><input type='submit' value=\"Pay Fines\" class='btn btn-danger'></td>\n");
      out.write("                                        </tr>\n");
      out.write("\n");
      out.write("                                        ");

                                            }
                                        
      out.write("\n");
      out.write("\n");
      out.write("                                    </table>\n");
      out.write("                                </form>\n");
      out.write("                                ");

                                    }
      out.write("\n");
      out.write("                                <table class=\"table table-striped\">\n");
      out.write("                                    ");

                                        if (request.getAttribute("listAllEntries") != null) {
                                            ArrayList<FineDetails> al = (ArrayList<FineDetails>) request.getAttribute("listAllEntries");
                                    
      out.write("\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Card Id</th>\n");
      out.write("                                        <th>First Name</th>\n");
      out.write("                                        <th>Last Name</th>\n");
      out.write("                                        <th>Fine Due</th>\n");
      out.write("                                        <!--<th>Amount Pay</th>-->\n");
      out.write("                                        <th></th>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");

                                        for (int i = 0; i < al.size(); i++) {
                                            FineDetails fd = al.get(i);
                                    
      out.write("\n");
      out.write("                                    <form action=\"PayFineServlet\">\n");
      out.write("                                        <!--<input type=\"text\" value=\"");
 //fd.getCardId()
      out.write("\">-->\n");
      out.write("                                        <tr>\n");
      out.write("                                            <td>");
      out.print(fd.getCardId());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(fd.getFirstName());
      out.write("</td>\n");
      out.write("                                            <td>");
      out.print(fd.getLastName());
      out.write("</td>\n");
      out.write("                                            <td>$ ");
      out.print(fd.getFine());
      out.write("</td>\n");
      out.write("                                        <input type=\"text\" value=\"");
      out.print(fd.getLoanId());
      out.write("\" name=\"loanId\" hidden=\"true\">\n");
      out.write("                                        <input type=\"text\" value=\"");
      out.print(fd.getCardId());
      out.write("\" name=\"CardId\" hidden=\"true\">\n");
      out.write("                                        <!--<td><input type=\"text\" value=\"\" name=\"FineAmtToPay\" class=\"form-group\"></td>-->\n");
      out.write("                                        <td><input type=\"submit\" value=\"Pay Fine\" class=\"btn btn-primary\"></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </form>\n");
      out.write("                                    ");

                                            }
                                        }
                                    
      out.write("\n");
      out.write("                                </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"panel panel-default\">\n");
      out.write("                            <div class=\"panel-heading main-color-bg\">\n");
      out.write("                                <h3 class=\"panel-title\">Previously paid fines</h3>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"panel-body\">\n");
      out.write("                                <table class=\"table table-striped\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <th>Title</th>\n");
      out.write("                                        <th>Date Out</th>\n");
      out.write("                                        <th>date In</th>\n");
      out.write("                                        <th>Due Date</th>\n");
      out.write("                                        <th>Fine Paid</th>\n");
      out.write("                                    </tr>\n");
      out.write("                                    ");

                                        if(request.getAttribute("previousFine") != null){
                                            ArrayList<FineDetails> alf = (ArrayList<FineDetails>)request.getAttribute("previousFine");
                                            for(int i=0;i<alf.size();i++){
                                                FineDetails fd1 = alf.get(i);
                                                
      out.write("\n");
      out.write("                                                <tr>\n");
      out.write("                                                    <td>");
      out.print(fd1.getTitle());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(fd1.getDateOut());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(fd1.getDateIn());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(fd1.getDueDate());
      out.write("</td>\n");
      out.write("                                                    <td>");
      out.print(fd1.getFine());
      out.write("</td>\n");
      out.write("                                                </tr>\n");
      out.write("                                                ");

                                            }
                                        }else{
                                        
      out.write("\n");
      out.write("                                        <tr>No Records found!!</tr>\n");
      out.write("                                        ");

                                        }
                                    
      out.write("\n");
      out.write("                                </table> \n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </section>\n");
      out.write("    <!--....................ADMIN PAGE CONTENT over.................. -->\n");
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
