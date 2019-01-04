<%-- 
    Document   : Checkout
    Created on : 15 Oct, 2017, 6:29:27 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Books Page</title>
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
        <script>
            $(document).ready(function () {
                //alert(0);
                $.ajax({
                    url: 'GetDataForAdmin',
                    success: function (data) {
                        //alert(data);
                        var list = $.parseJSON(data);
                        //alert(list);
                        $('#totalUser').html(list[0]);
                        $('#newUser').html(list[1]);

                        $('#totalUsers').html(list[0]);
                        $('#newUsers').html(list[1]);
                    }
                });
            });
        </script>
    </head>
    <body>
        <!-- ADMIN HEADER STARTS -->
        <%@ include file="AdminHeader.jsp" %>
        <!-- ADMIN HEADER STARTS -->
        <!--....................ADMIN PAGE CONTENT.................. -->
        <section id="main" style="padding: 2em;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="list-group">
                            <%@include file='AdminVerticalHeader.jsp' %>

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
                                <h3 class="panel-title">CheckOut Books</h3>
                            </div>

                            <div class="panel-body">
                                <table class="table table-striped">
                                    <tr>
                                        <th>
                                        </th>
                                        <th></th>

                                    </tr>
                                </table> 


                                <table class="table table-striped table-hover"> 
                                    <tr><div class="books">
                                        <table class="table table-striped table-hover" id="table">
                                            <%
                                                if (request.getAttribute("Isbn10") != null) {
                                            %>
                                            
                                            
                                            <tr>
                                                <td><img src="<%=request.getAttribute("Cover")%>" class="img-thumbnail" alt="Cinque Terre"></td>
                                                <td>Title : <%=request.getAttribute("Title")%>
                                                    <br> Isbn: <%=request.getAttribute("Isbn10")%>
                                                    <br>Authors:<%=request.getAttribute("Authors")%><br><hr>
                                                    <form action="CheckOutfromDbServlet">
                                                        <label>Card No:</label>
                                                        <input type="text" class="form-group" name="CardNo" style="margin-left:10px;">
                                                        <input type="hidden" name="Isbn10" value="<%=request.getAttribute("Isbn10")%>">
                                                        <input type="submit" value="CheckOut" class="btn btn-primary">

                                                    </form>

                                                </td>
                                            
                                            </tr>
                                               
                                                <%
                                                        
                                                    }
                                                    if(request.getAttribute("AvailableCheck")!=null){
                                                %>
                                                <tr>Msg:<%=request.getAttribute("AvailableCheck")%></tr>
                                                <%}%>
                                        </table>

                                    </div>
                                    </tr>
                                </table>
                            </div>

                        </div>


                    </div>
                </div>
            </div>
        </section>
        <!--....................ADMIN PAGE CONTENT over.................. -->
    </body>
</html>
