<%-- 
    Document   : Login
    Created on : 30 Jan, 2017, 4:08:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
        <link href="css/style.css" rel='stylesheet' type='text/css' />
        <link href="css/font-awesome.min.css" rel='stylesheet' type='text/css' />
        <link href="css/font_awesome.css" rel='stylesheet' type='text/css' />
        <link href="css/feedbackstyle.css" rel='stylesheet' type='text/css' />

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <script src="js/jquery.min.js"></script>

        <link rel="stylesheet" href="css/fwslider.css" media="all">
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/fwslider.js"></script>

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
            .modal {
                display:hidden; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 100000;/*sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            }
            .modal-content {
                background-color: #fefefe;
                margin: 15% auto; /* 15% from the top and centered */
                padding: 20px;
                border: 1px solid #888;
                width: 80%; /* Could be more or less, depending on screen size */
            }
        </style>

    </head>
    <body>

        <!-- ................header starts....................... -->
        <%@ include file="Header.jsp" %> 
        <!-- ................header ends   ....................... -->


        <div class="banner">
            <!-- start slider -->
            <div id="fwslider">
                <div class="slider_container">
                    <div class="slide"> 
                        <!-- Slide image -->
                        <img src="images/slider1.jpg" class="img-responsive" alt=""/>
                        <!-- /Slide image -->
                        <!-- Texts container -->
                        <div class="slide_content">
                            <div class="slide_content_wrap">
                                <!-- Text title -->
                                <h1 class="title">Run Over<br>Everything</h1>
                                <!-- /Text title -->
                                <div class="button"><a href="#">See Details</a></div>
                            </div>
                        </div>
                        <!-- /Texts container -->
                    </div>
                    <!-- /Duplicate to create more slides -->
                    <div class="slide">
                        <img src="images/slider2.jpg" class="img-responsive" alt=""/>
                        <div class="slide_content">
                            <div class="slide_content_wrap">
                                <h1 class="title">Run Over<br>Everything</h1>
                                <div class="button"><a href="#">See Details</a></div>
                            </div>
                        </div>
                    </div>
                    <!--/slide -->
                </div>
                <div class="timers"></div>
                <div class="slidePrev"><span></span></div>
                <div class="slideNext"><span></span></div>
            </div>
            <!--/slider -->
        </div>
        <div class="main">
            <div class="content-top">
                <h2>snowboards</h2>
                <p>hendrerit in vulputate velit esse molestie consequat, vel illum dolore</p>
                <div class="close_but"><i class="close1"> </i></div>
                <ul id="flexiselDemo3">
                    <li><img src="images/board1.jpg" /></li>
                    <li><img src="images/board2.jpg" /></li>
                    <li><img src="images/board3.jpg" /></li>
                    <li><img src="images/board4.jpg" /></li>
                    <li><img src="images/board5.jpg" /></li>
                </ul>
                <h3>SnowBoard Extreme Series</h3>
                <script type="text/javascript">
                    $(window).load(function () {
                        $("#flexiselDemo3").flexisel({
                            visibleItems: 5,
                            animationSpeed: 1000,
                            autoPlay: true,
                            autoPlaySpeed: 3000,
                            pauseOnHover: true,
                            enableResponsiveBreakpoints: true,
                            responsiveBreakpoints: {
                                portrait: {
                                    changePoint: 480,
                                    visibleItems: 1
                                },
                                landscape: {
                                    changePoint: 640,
                                    visibleItems: 2
                                },
                                tablet: {
                                    changePoint: 768,
                                    visibleItems: 3
                                }
                            }
                        });

                    });
                </script>
                <script type="text/javascript" src="js/jquery.flexisel.js"></script>
            </div>
        </div>
        <div class="content-bottom">
            <div class="container">
                <div class="row content_bottom-text">
                    <div class="col-md-7">
                        <h3>The Mountains<br>Snowboarding</h3>
                        <p class="m_1">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio.</p>
                        <p class="m_2">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="features">
            <div class="container">
                <h3 class="m_3">Features</h3>
                <div class="close_but"><i class="close1"> </i></div>
                <div class="row">
                    <div class="col-md-3 top_box">
                        <div class="view view-ninth"><a href="single.html">
                                <img src="images/pic1.jpg" class="img-responsive" alt=""/>
                                <div class="mask mask-1"> </div>
                                <div class="mask mask-2"> </div>
                                <div class="content">
                                    <h2>Hover Style #9</h2>
                                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                                </div>
                            </a> </div
                    </div>
                    <h4 class="m_4"><a href="#">nostrud exerci ullamcorper</a></h4>
                    <p class="m_5">claritatem insitam</p>
                </div>
                <div class="col-md-3 top_box">
                    <div class="view view-ninth"><a href="single.html">
                            <img src="images/pic2.jpg" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Hover Style #9</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">nostrud exerci ullamcorper</a></h4>
                    <p class="m_5">claritatem insitam</p>
                </div>
                <div class="col-md-3 top_box">
                    <div class="view view-ninth"><a href="single.html">
                            <img src="images/pic3.jpg" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Hover Style #9</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">nostrud exerci ullamcorper</a></h4>
                    <p class="m_5">claritatem insitam</p>
                </div>
                <div class="col-md-3 top_box1">
                    <div class="view view-ninth"><a href="single.html">
                            <img src="images/pic4.jpg" class="img-responsive" alt=""/>
                            <div class="mask mask-1"> </div>
                            <div class="mask mask-2"> </div>
                            <div class="content">
                                <h2>Hover Style #9</h2>
                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing.</p>
                            </div>
                        </a> </div>
                    <h4 class="m_4"><a href="#">nostrud exerci ullamcorper</a></h4>
                    <p class="m_5">claritatem insitam</p>
                </div>
            </div>
        </div>
    </div>
    <!-- <div class="main">
         <div class="shop_top">
             <div class="container">
                 <div class="col-md-6">
                     <div class="login-page">
                         <h4 class="title">New Customers</h4>
                         <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis</p>
                         <div class="button1">
                             <a href="Register.jsp"><input type="submit" name="Submit" value="Create an Account"></a>
                         </div>
                         <div class="clear"></div>
                     </div>
                 </div>
                 <div class="col-md-6">
                     <div class="login-title">
                         <h4 class="title">Registered Customers</h4>
                         <div id="loginbox" class="loginbox">
                             <form action="LoginServlet" name="login" id="login-form">
                                 <fieldset class="input">
                                     <p id="login-form-username">
                                         <label for="modlgn_username">Email</label>
                                         <input id="modlgn_username" type="text" name="email" class="inputbox" size="18">
                                     </p>
                                     <p id="login-form-password">
                                         <label for="modlgn_passwd">Password</label>
                                         <input id="modlgn_passwd" type="text" name="password" class="inputbox" size="18">
                                     </p>
                                     <div class="remember">
                                         <p id="login-form-remember">
                                             <label for="modlgn_remember"><a href="#">Forget Your Password ? </a></label>
                                         </p>
                                         <input type="submit" class="button" value="Login"><div class="clear"></div>
                                     </div>
                                 </fieldset>
                             </form>
                         </div>
                     </div>
                     <div class="clear"></div>
                 </div>
             </div>
         </div>
     </div>-->


    
    <!-- ...........footer goes here.................... -->
    <%--<%@include file="Footer.jsp" %>--%>
    <!--............ footer ends........................ -->
    <div>
      
    </div>
</body>
</html>
