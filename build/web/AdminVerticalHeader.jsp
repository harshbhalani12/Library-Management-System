<%-- 
    Document   : AdminVerticalHeader
    Created on : 13 May, 2017, 10:34:20 PM
    Author     : Admin
--%>
<script>
            $(document).ready(function(){
                //alert(0);
                $.ajax({
                    url: 'GetDataForAdmin',
                    success:function(data){
                        //alert(data);
                        var list = $.parseJSON(data);
                        //alert(list);
                        $('#totalUser').html(list[0]);
                        $('#newUser').html(list[1]);
                        $('#serviceProvider').html(list[2]);
                        
                        $('#totalUsers').html(list[0]);
                        $('#newUsers').html(list[1]);
                    }
                });
            });
        </script>

        <a href="#" class="list-group-item active main-color-bg">
    <span class="fa fa-user-circle" aria-hidden="true"></span> Welcome Harsh <span>
        <a href="Logout.jsp"><i class="fa fa-power-off pull-right"></i></a>
    </span>
</a>
<a href="ManageBooks.jsp" class="list-group-item">
    <span class="fa fa-search" aria-hidden="true"></span>
    <span style="padding:5px;">Search Books</span> 
    <span class="badge" id="totalUser">></span>
</a>
<a href="AddBorrower.jsp" class="list-group-item">
    <span class="fa fa-plus" aria-hidden="true"></span>
    <span style="padding:0px;"> Add New Borrower</span>
    <span class="badge"><span> > </span></span></a>
<a href="ManageBooks.jsp" class="list-group-item">
    <span class="fa fa-group" aria-hidden="true"></span>
        <span style="padding:0px;"> Manage Books</span>  
    <span class="badge" id="newUser"><span> > </span></span>
</a>
<a href="CheckFines.jsp" class="list-group-item">
    <span class="fa fa-shopping-cart" aria-hidden="true"></span> Check Fines
    <span class="badge" id="serviceProvider"><span> > </span></span>
   
</a>