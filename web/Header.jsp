<div class="header">

    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="header-left">
<!--                    <div class="logo">
                        <a href="home.jsp"><img src="images/logo.png" alt=""/></a>
                    </div>-->
                    <div class="menu">
                        <a class="toggleMenu" href="#"><img src="images/nav.png" alt="" /></a>
                        <ul class="nav" id="nav">
                            <!--
                            <li><a href="shop.html">Shop</a></li>
                            <li><a href="team.html">Team</a></li>
                            <li><a href="shop.html">Events</a></li>
                            <li><a href="experiance.html">Experiance</a></li>
                            <li><a href="shop.html">Company</a></li>
                            <li><a href="contact.html">Contact</a></li>								
                            -->
                            <li><a href="ElectronicsServlet">Electronics</a></li>
                            <li><a href="#">Home</a></li>
                            <li><a href="FashionServlet">Fashion</a></li>
                            <li><a href="#">Company</a></li>
                            <li><a href="contact.jsp">Contact</a></li>
                            <li><a href="Login.jsp">Login</a></li>
                            
                            <div class="clear"></div>
                        </ul>
                        <script type="text/javascript" src="js/responsive-nav.js"></script>
                    </div>							
                    <div class="clear"></div>
                </div>
                <div class="header_right">
                    <!-- start search-->
                    <div class="search-box">
                        <div id="sb-search" class="sb-search">
                            <form>
                                <input class="sb-search-input" placeholder="Enter your search term..." type="search" name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search"> </span>
                            </form>
                        </div>
                    </div>
                    <!----search-scripts---->
                    
                    <script src="js/classie.js"></script>
                    <script src="js/uisearch.js"></script>
                    
                    <script>
                        new UISearch( document.getElementById( 'sb-search' ) );
                    </script>
                    <ul class="icon1 sub-icon1 profile_img">
                        <li><!--<a class="active-icon " href="#"> </a>-->
                            <a class="fa fa-shopping-cart" href="CartServlet" id="cart"> </a>
                            
                            
                            
<!--                            <ul class="sub-icon1 list" style="height: 100px;">
                                <div class="product_control_buttons">
                                    <a href="#"><img src="images/edit.png" alt=""/></a>
                                    <a href="#"><img src="images/close_edit.png" alt=""/></a>
                                </div>
                                <div class="clear"></div>
                                <li class="list_img"><img src="images/1.jpg" alt=""/></li>
                                <li class="list_desc"><h4><a href="#">velit esse molestie</a></h4><span class="actual">1 x
                                        $12.00</span></li>
                                <div class="login_buttons">
                                    <div class="check_button"><a href="CartServlet">Check out</a></div>
                                    <div class="login_button"><a href="Login.jsp">Login</a></div>
                                    <div class="clear"></div>
                                </div>
                                <div class="clear"></div>
                            </ul>-->
                        </li>
                        
                    </ul>
                    <div class="clear"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="float: right;margin-right: 150px; z-index: 100;">
    <a href="Login.jsp" style="background: #000; color: #fff; padding: 5px 15px; border-radius: 5px">Login</a>
    <a href="Logout.jsp" id="logoutId" style="background: #000; color: #fff; padding: 5px 15px; border-radius: 5px;" >LogOut</a>
</div>
