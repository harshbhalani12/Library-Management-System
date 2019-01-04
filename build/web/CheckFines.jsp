<%-- 
    Document   : CheckFines
    Created on : 15 Oct, 2017, 11:44:59 PM
    Author     : Admin
--%>

<%@page import="model.FineDetails"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Borrower"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check Fines Page</title>
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
                                <h3 class="panel-title">Fines</h3>
                            </div>

                            <div class="panel-body">
                                <table class="table table-striped">
                                    <%
                                        if (request.getAttribute("msg") != null) {
                                    %>
                                    <tr><%=request.getAttribute("msg")%></tr>
                                    <%
                                        }
                                    %>
                                    <tr>
                                        <th>
                                            Please Click on the Update button to update all fines.
                                        </th>
                                        <th>
                                            <a href="UpdateAllFines" class="btn btn-danger">Update Fines</a>
                                        </th>

                                    </tr>
                                    <tr>
                                        <td><form action="ListAllFineServlet"><input type="submit" value="List all Fines" class="btn btn-info"></form></td>
                                    </tr>
                                </table> 



                                <table class="table table-striped table-hover" id="table">
                                    <tr>
                                        <td>
                                            <form action="CheckFineForBorrowerServlet">
                                                <label>Card No:</label>
                                                <input type="text" class="form-group" name="CardNo" style="margin-left:10px;">
                                                <!--<input type="hidden" name="Isbn10" value="<%//request.getAttribute("Isbn10")%>">-->
                                                <input type="submit" value="Search" class="btn btn-primary">
                                            </form>
                                        </td>
                                        <td>
                                            <%
                                                if (request.getAttribute("msg") != null) {
                                            %>
                                            <%=request.getAttribute("msg")%>
                                            <%
                                                }
                                            %>

                                        </td>
                                    </tr>
                                </table>

                                <%
                                    if (request.getAttribute("list") != null) {
                                        ArrayList<FineDetails> al = (ArrayList<FineDetails>) request.getAttribute("list");
                                %>
                                <form action='PayFineServlet'>
                                    <table class="table table-striped table-hover">
                                        <tr>
                                            <th>Card Id</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Fine Due</th>
                                            <!--<th>hello</th>-->
                                            <!--<th>Amount Pay</th>-->
                                            <th></th>
                                        </tr>
                                        <%
                                            for (int i = 0; i < al.size(); i++) {
                                                FineDetails b = al.get(i);
                                        %>
                                        <tr>
                                            <td><%=b.getCardId()%></td>
                                            <td><%=b.getFirstName()%></td>
                                            <td><%=b.getLastName()%></td>
                                            <td><%=b.getFine()%></td>
                                            <!--<td><%//b.getLoanId()%></td>-->
                                        <input type="text" value="<%=b.getLoanId()%>" name="loanId" hidden="true">
                                        <input type="text" value="<%=b.getCardId()%>" name="CardId" hidden="true">
                                        <!--<td><input type="text" value="" name="FineAmtToPay" class="form-group"></td>-->
                                        <td><input type='submit' value="Pay Fines" class='btn btn-danger'></td>
                                        </tr>

                                        <%
                                            }
                                        %>

                                    </table>
                                </form>
                                <%
                                    }%>
                                <table class="table table-striped">
                                    <%
                                        if (request.getAttribute("listAllEntries") != null) {
                                            ArrayList<FineDetails> al = (ArrayList<FineDetails>) request.getAttribute("listAllEntries");
                                    %>
                                    <tr>
                                        <th>Card Id</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Fine Due</th>
                                        <!--<th>Amount Pay</th>-->
                                        <th></th>
                                    </tr>
                                    <%
                                        for (int i = 0; i < al.size(); i++) {
                                            FineDetails fd = al.get(i);
                                    %>
                                    <form action="PayFineServlet">
                                        <!--<input type="text" value="<% //fd.getCardId()%>">-->
                                        <tr>
                                            <td><%=fd.getCardId()%></td>
                                            <td><%=fd.getFirstName()%></td>
                                            <td><%=fd.getLastName()%></td>
                                            <td>$ <%=fd.getFine()%></td>
                                        <input type="text" value="<%=fd.getLoanId()%>" name="loanId" hidden="true">
                                        <input type="text" value="<%=fd.getCardId()%>" name="CardId" hidden="true">
                                        <!--<td><input type="text" value="" name="FineAmtToPay" class="form-group"></td>-->
                                        <td><input type="submit" value="Pay Fine" class="btn btn-primary"></td>
                                        </tr>
                                    </form>
                                    <%
                                            }
                                        }
                                    %>
                                </table>


                            </div>


                        </div>

                        <div class="panel panel-default">
                            <div class="panel-heading main-color-bg">
                                <h3 class="panel-title">Previously paid fines</h3>
                            </div>

                            <div class="panel-body">
                                <table class="table table-striped">
                                    <tr>
                                        <th>Card No.</th>
                                        <th>Title</th>
                                        <th>Date Out</th>
                                        <th>Date In</th>
                                        <th>Due Date</th>
                                        <th>Fine Paid</th>
                                    </tr>
                                    <%
                                        
                                        if(request.getAttribute("previousFine") != null){
                                            ArrayList<FineDetails> alf = (ArrayList<FineDetails>)request.getAttribute("previousFine");
                                            
                                            if(alf.isEmpty()){
                                                   %>
                                                   <tr>No Previous history found</tr>
                                                   <%
                                                }
                                            
                                            for(int i=0;i<alf.size();i++){
                                                FineDetails fd1 = alf.get(i);
                                                %>
                                                <tr>
                                                    <td><%=fd1.getCardId()%></td>
                                                    <td width="250px"><%=fd1.getTitle()%></td>
                                                    <td><%=fd1.getDateOut()%></td>
                                                    <td><%=fd1.getDateIn()%></td>
                                                    <td><%=fd1.getDueDate()%></td>
                                                    <td><%=fd1.getFine()%></td>
                                                </tr>
                                                <%
                                                
                                            }
                                        }
                                    %>
                                </table> 
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </section>
    <!--....................ADMIN PAGE CONTENT over.................. -->
</body>
</html>
