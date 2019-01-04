<%-- 
    Document   : AdminPage
    Created on : 24 Feb, 2017, 8:37:54 AM
    Author     : Admin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Borrower Page</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
        <link href="css/style_1.css" rel='stylesheet' type='text/css' />

        <link href="css/font_awesome.css" rel='stylesheet' type='text/css' />
        <link href="css/adminheadercss.css" rel='stylesheet' type='text/css' />

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $(".dropdown img.flag").addClass("flagvisibility");

                $(".dropdown dt a").click(function () {
                    $(".dropdown dd ul").toggle();
                });

                $(".dropdown dd ul li a").click(function () {
                    var text = $(this).html();
                    $(".dropdown dt a span").html(text);
                    $(".dropdown dd ul").hide();
                    $("#result").html("Selected value is: " + getSelectedValue("sample"));
                });

                function getSelectedValue(id) {
                    return $("#" + id).find("dt a span.value").html();
                }

                $(document).bind('click', function (e) {
                    var $clicked = $(e.target);
                    if (!$clicked.parents().hasClass("dropdown"))
                        $(".dropdown dd ul").hide();
                });


                $("#flagSwitcher").click(function () {
                    $(".dropdown img.flag").toggleClass("flagvisibility");
                });
            });
        </script>

        <style>
            @keyframes burst{
                0%{
                    opacity:.6;
                }
                50%{
                    transform: scale(2.5);
                    opacity: 0;
                }
                100%{
                    opacity: 0;
                }

            }
            .user:hover .faa-burst.animated{
                animation: burst 3s infinite linear;
            }
            .usergroup:hover .faa-burst.animated{
                animation: burst 3s infinite linear;
            }
            .shoppingcart:hover .faa-burst.animated{
                animation: burst 3s infinite linear;
            }
            .visitors:hover .faa-burst.animated{
                animation: burst 3s infinite linear;
            }


        </style>
    </head>
    <body>
        <!-- ADMIN HEADER STARTS -->
        <%@ include file="AdminHeader.jsp" %>
        <!-- ADMIN HEADER ENDS -->
        
        <%
//            HttpSession hs = request.getSession();
//            String name = hs.getAttribute("Name").toString();
//            String id = hs.getAttribute("LoginId").toString();
            //out.println("LoginId" + hs.getAttribute("LoginId"));
        %>
        <!--....................ADMIN PAGE CONTENT.................. -->
        <section id="main" style="padding: 2em;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="list-group">
                            <%@include file="AdminVerticalHeader.jsp" %>
<!--                            <a href="index.html" class="list-group-item active main-color-bg">
                                <span class="fa fa-user-circle" aria-hidden="true"></span> Welcome  <span><i class="fa fa-power-off pull-right"></i></span>
                            </a>
                            <a href="ServiceProviderPage.jsp" class="list-group-item"><span class="fa fa-plus" aria-hidden="true"></span><span style="padding:5px;">Add Product</span> <span class="badge"></span></a>
                            <a href="ViewProductServlet" class="list-group-item"><span class="fa fa-eye" aria-hidden="true"></span><span style="padding:0px;"> View All Products</span><span class="badge">33</span></a>
                            <a href="ViewProductServlet" class="list-group-item"><span class="fa fa-gears" aria-hidden="true"></span> Manage Products <span class="badge">203</span></a>
                            <a href="#" class="list-group-item"><span class="fa fa-shopping-cart" aria-hidden="true"></span> Sales <span class="badge">203</span></a>-->
                        </div>

                        <div class="well" style="padding:0;">
                            <canvas id="canvas" width="500" height="500" style="display: none;"></canvas>
                            <img id="myImage" width="260" height="260"/>

                            <script src="js/clock.js"></script>

                        </div>


                    </div>
                    <div class="col-md-9">
                        <!-- Website Overview -->
                        <div class="panel panel-default">
                            <div class="panel-heading main-color-bg">
                                <h3 class="panel-title">Add Borrower</h3>
                            </div>
                            <div class="panel-body">
                                <form action="AddBorrowersServlet" method="POST" class="form-horizontal">
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>First Name : <span style="color:red;">*</span> </label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="firstName">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>Last Name : <span style="color:red;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="lastName">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>SSN : <span style="color:red;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="ssn">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>Email Id : <span style="color:red;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="emailId">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>Address :<span style="color:red;">*</span> </label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="address">
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>City : <span style="color:red;">*</span></label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="city">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>State :<span style="color:red;">*</span> </label>
                                        </div>
                                        <div class="col-sm-9">
                                            <input type="text" name="state">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <div class="col-sm-3">
                                            <label>Phone Number : <span style="color:red;">*</span></label>
                                        </div>
                                        <div class="col-sm-6">
                                            <input type="text" name="phoneNumber">
                                        </div>
                                    </div>
                                        
                                    <div class="form-group">
                                        <div class="col-sm-offset-2">
                                            
                                            <input type="submit" value="Add Borrower" class="btn btn-primary">
                                            
                                        </div>
                                    </div>
                                       <div class="form-group">
                                        <div class="col-sm-offset-2">
                                                                                                                                  
                                            <label><% if(request.getAttribute("error")!= null){
                                                         out.println(request.getAttribute("error"));
                                                       } else{
                                                       }
                                                      if(request.getAttribute("msg")!=null){
                                                          out.println(request.getAttribute("msg"));
                                                          out.println("<br><h3>Your Card Number is : "+request.getAttribute("msg2")+"<h3>");
                                                      } else{
                                                      }
                                                    %>
                                            </label>
                                        </div>
                                    </div> 
                                </form>
                            </div>
                        </div>

                       
                    </div>
                </div>
            </div>
        </section>
        <!--....................ADMIN PAGE CONTENT over.................. -->
    </body>
</html>
