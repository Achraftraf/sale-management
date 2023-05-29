<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet"> 
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body onload="findAll()">
    <div class="container-fluid position-relative d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->

		
        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a href="index.html" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-  font-variation-settings me-2"></i>G Vente </h3>
                </a>
                
                <div class="navbar-nav w-100">
                    <a href="index.jsp" class="nav-item nav-link "><i class="fas fa-user-alt me-2"></i>Users</a>
                    <div class="nav-item">
                        <a  class="nav-link dropdown-toggle active"><i class="	fas fa-shopping-cart me-2"></i>Items</a>
            
                    </div>
                    <a href="order.jsp	" class="nav-item nav-link"><i class="fa fa-th me-2"></i>Orders</a>
                
                  
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
 
            <!-- Navbar End -->

            <!-- Sale & Revenue End -->


            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Items List</h6>
                    </div>
                    
                    
  
                    
                    
                    
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0" >
                           <thead>
                                <tr class="text-white">
                                    <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                    <th scope="col">Items Code</th>
                                    <th scope="col">Items Name</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Price</th>
                                </tr>
                           </thead>
                            <tbody  id="tbody">
                            
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- Recent Sales End -->


            <!-- Widgets Start -->
            	
		
		

        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>
    </div>
    


    <!-- Code jQuery pour afficher les information de l'utlisateur -->
    
	 <script type="text/javascript">
        let utili = [];
    function findAll(){
    	$.ajax({			
    		type:"GET",
    		url:"loadAll.action",
    		success: function(result){
    			var tblData="";
    			utili=result.articles;
    			$.each(result.articles, function() {	
    					console.log(result.articles)
    				tblData += '<tr>'
                       +' <td><input class="form-check-input" type="checkbox"></td>'
                       +'<td>'+this[0].codeArt+'</td>'
                       +' <td>'+this[0].nomArt+'</td>'
                       +' <td>'+this[0].descArt+'</td>'
                       +' <td>'+this[0].artickStock.qteArt+'</td>'
                       +' <td>'+this[0].prixArt+'</td>'
                       +'</tr>'   ;                                                                                              
    				});
    			$("#tbody").html(tblData);
    		},
    		error: function(result){
    			alert("Some error occured.");
    		}
    	})
    }
    </script>
    
    
        <script type="text/javascript">
    function edit(e){
    	console.log("ok : "+e)
    	let obj = utili.find(o => o.codeUser === e);
    	console.log(obj)
		$('#modalEdit').modal('show');
    	document.getElementById("CodeUser").value=obj.codeUser;
    	document.getElementById("Login").value=obj.login;
    	document.getElementById("Pass").value=obj.pass;
		
    }
     </script>
     
     
       <script type="text/javascript">
    function delet(e){
    	console.log("ok : "+e)
    	let obj = utili.find(o => o.codeUser === e);
    	console.log(obj);
    	$('#download').modal('show');
    	document.getElementById("CodeUserd").value=obj.codeUser;
    	document.getElementById("Logind").value=obj.login;
    	document.getElementById("Passd").value=obj.pass;
		
    }
     </script>
           


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body >
</html>