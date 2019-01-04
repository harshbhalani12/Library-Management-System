<script>
    $(document).ready(function(){
       //alert("admin link alert");
       $.ajax({
           
           type: "POST",
           url:'GetSPRequestForAdmin',
           success:function(data){
               $('#messages').html(data);
           }
       });
    });
</script>

<div class="header" style="height: 70px; padding:0.5% 0;">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="header-left">
                    <div class="logo">
                        <!--<a href="index.html"><img src="images/logo.png" alt=""/></a>-->
                    </div>
                    <div class="menu">
                        <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>

                        <ul class="" id="">

                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                    <i class="fa fa-envelope"></i>
                                    <span class="badge" id="messages">0</span>
                                </a>
                            </li>
                            <li class="dropdown head-dpdn">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                    <i class="fa fa-bell"></i>
                                    <span class="badge">0</span>
                                </a>
                            </li>
                            <li class="dropdown head-dpdn">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                    <i class="fa fa-tasks"></i>
                                    <span class="badge">0</span>
                                </a>
                            </li>
                            <div class="clear"></div>
                        </ul>
                        <script type="text/javascript" src="js/responsive-nav.js"></script>
                        <!--
                        <ul class="" id="" style="margin:0;">
                        <!--
                        <li><a href="#">Electronics</a></li>
                        <li><a href="#">Home</a></li>
                        <div class="clear"></div>
                        -->
                        <!--
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                <i class="fa fa-envelope"></i>
                                <span class="badge">3</span>
                            </a>
                        </li>
                        <ul class="dropdown-menu">
                            <li>

                                <div class="notification-header">
                                    You have 3 new Notifications
                                </div>
                            </li>


                        </ul>
                        <li class="dropdown head-dpdn">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                <i class="fa fa-bell"></i>
                                <span class="badge">2</span>
                            </a>
                        </li>
                        <li class="dropdown head-dpdn">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" area-exapanded="false">
                                <i class="fa fa-tasks"></i>
                                <span class="badge">3</span>
                            </a>
                        </li>

                    </ul>
                        -->
                        <script type="text/javascript" src="js/responsive-nav.js"></script>
                    </div>							
                    <div class="clear"></div>



                    <!-- start search-->

                    <div id="sb-search" class="sb-search sb-search-open" style="float:left;">
                        <form>
                            <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                            <input class="sb-search-submit" type="submit" value="">
                            <span class="sb-icon-search"> </span>
                        </form>
                    </div>

                    <!----search-scripts---->

                    <script src="js/classie.js"></script>
                    <script src="js/uisearch.js"></script>

                    <script>
                        new UISearch(document.getElementById('sb-search'));
                    </script>

                    <div class="clear"></div>
                </div>
                <div class="header_right">
                    <!-- 
                     <ul class="icon1 sub-icon1 profile_img">
                         <li><a class="active-icon c1" href="#"> </a>
                             <ul class="sub-icon1 list">
                                 <div class="product_control_buttons">
                                     <a href="#"><img src="images/edit.png" alt=""/></a>
                                     <a href="#"><img src="images/close_edit.png" alt=""/></a>
                                 </div>
                                 <div class="clear"></div>
                                 <li class="list_img"><img src="images/1.jpg" alt=""/></li>
                                 <li class="list_desc"><h4><a href="#">velit esse molestie</a></h4><span class="actual">1 x
                                         $12.00</span></li>
                                 <div class="login_buttons">
                                     <div class="check_button"><a href="checkout.html">Check out</a></div>
                                     <div class="login_button"><a href="Login.jsp">Login</a></div>
                                     <div class="clear"></div>
                                 </div>
                                 <div class="clear"></div>
                             </ul>
                         </li>
                     </ul>
                     <div class="clear"></div>
                    -->
                </div>
            </div>
        </div>
    </div>
</div>

<div style="float: right;margin-right: 150px; z-index: 100;">
<!--    <a href="Login.jsp" style="background: #000; color: #fff; padding: 5px 15px; border-radius: 5px">Login</a>-->
    <!--<a href="Logout.jsp" id="logoutId" style="background: #000; color: #fff; padding: 5px 15px; border-radius: 5px;" >LogOut</a>-->
</div>

<!--<div class="side-nav">
    <nav>
        <ul>
            <li>
                <a href="AdminPage.jsp"> 
                    <span> <i class="fa fa-user"></i></span>
                </a>
            </li>

            <li>
                <a href="#">
                    <span><i class="fa fa-envelope"></i></span>

                </a>
            </li>
            <li class="active">
                <a href="#">
                    <span><i class="fa fa-bar-chart"></i></span>

                </a>
            </li>
            <li>
                <a href="FeedbackShowServlet">
                    <span><i class="fa fa-credit-card-alt"></i></span>

                </a>
            </li>
        </ul>
    </nav>
</div>-->



