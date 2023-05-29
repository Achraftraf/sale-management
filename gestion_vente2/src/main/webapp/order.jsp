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
        <div class="modal" id="download" tabindex="-1" role="dialog">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Facture</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<p>Your can download here !</p>
					</div>
					<div class="modal-footer">
						<a target="_blank"
							href="http://localhost:8081/gestion_vente2/Fact.pdf"
							type="button" class="btn btn-primary">Download</a>
						<button type="button" class="btn btn-secondary close"
							data-bs-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

		
        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-secondary navbar-dark">
                <a  class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-  font-variation-settings me-2"></i>G Vente </h3>
                </a>
                
                <div class="navbar-nav w-100">
                    <a href="index.jsp" class="nav-item nav-link "><i class="fas fa-user-alt me-2"></i>Users</a>
                    <div class="nav-item">
                        <a href="items.jsp" class="nav-link dropdown-toggle"><i class="	fas fa-shopping-cart me-2"></i>Items</a>
            
                    </div>
                    <a class="nav-item nav-link active"><i class="fa fa-th me-2"></i>Orders</a>
                
                  
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->



        <form method="post" action="UpdCommande.action"
								class="modal fade" id="modalEdit" tabindex="-1"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="modalCenterTitle">Modifier 
												une commande</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">

											<div class="row g-2">
												<div class="col mb-0">
													<label for="emailWithTitle" class="form-label">Code
														de la commande</label> <input type="number" id="CodeCmd"
														name="codeCmd" class="form-control"
														placeholder="Entrez le code de la commande" />
												</div>
												<div class="col mb-0">
													<label for="dobWithTitle" class="form-label">Nom du
														client</label> <input type="text" id="NomC" name="client"
														class="form-control" placeholder="Entrez le nom du client" />
												</div>
											</div>

											<div class="row g-2">
												<div class="col mb-0">
													<label for="emailWithTitle" class="form-label">Code
														d'article</label> <input type="number" id="codeArt" name="codeArt"
														class="form-control"
														placeholder="Entrez le code d'article" />
												</div>

												<div class="col mb-0">
													<label for="dobWithTitle" class="form-label">Quantité
														de la commande</label> <input type="number" id="qnt" name="qteCmd"
														class="form-control"
														placeholder="Entrez le prix d'article" />
												</div>

												<div class="col mb-0">
													<label for="dobWithTitle" class="form-label">Date
														de la commande</label> 
														<input type="date" id="date" name="dateCmd"
														class="form-control"
														placeholder="Entrez la date de la commande" />
												</div>

											</div>

										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-outline-secondary"
												data-bs-dismiss="modal">Fermer</button>
											<input type="submit" class="btn btn-primary"
												value="Modifier" id="Acsh" />
										</div>
									</div>
								</div>
						</div>
						</form>


        <!-- Content Start -->
        <div class="content">
            <!-- Navbar Start -->
 
            <!-- Navbar End -->

            <!-- Sale & Revenue End -->


            <!-- Recent Sales Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-secondary text-center rounded p-4">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <h6 class="mb-0">Orders List</h6>
                        <Button class="btn btn-info" data-bs-toggle="modal"
                                data-bs-target="#modalCenter">add order</a>
                    
                    </div>
                    
                    <form method="post" action="addCommande.action" class="modal fade" id="modalCenter" tabindex="-1" aria-hidden="true">
                          <div class="modal-dialog modal-dialog-centered" role="document">
                            <div class="modal-content">
                              <div class="modal-header">
                                <h5 class="form-label" id="modalCenterTitle">Add an order </h5>
                                <button
                                  type="button"
                                  class="btn-close"
                                  data-bs-dismiss="modal"
                                  aria-label="Close"
                                ></button>
                              </div>
                              <div class="modal-body">
                                
                                <div class="row g-2">
                                  
                                  <div class="col mb-0">
                                    <label for="dobWithTitle" class="form-label">Order Code</label>
                                    <input
                                      type="number"
                                      id="dobWithTitle"
                                      name="codeCmd"
                                      class="form-control"
                                      placeholder="Enter your order code"
                                    />
                                  </div>
                                </div>

                                <div class="row g-2">
                                  <div class="col mb-0">
                                    <label for="emailWithTitle" class="form-label">Client Name</label>
                                    <input
                                      type="text"
                                      id="emailWithTitle"
                                      name="client"
                                      class="form-control"
                                      placeholder="Enter your client name"
                                    />
                                  </div>
                              
                                </div>
                                <div class="row g-2">
                                  <div class="col mb-0">
                                    <label for="emailWithTitle" class="form-label">Items Code</label>
                                    <input
                                      type="number"
                                      id="emailWithTitle"
                                      name="codeArt"
                                      class="form-control"
                                      placeholder="Enter your item code"
                                    />
                                  </div>
                              
                                </div>
                                <div class="row g-2">
                                  <div class="col mb-0">
                                    <label for="emailWithTitle" class="form-label">Order Date</label>
                                    <input
                                      type="date"
                                      id="emailWithTitle"
                                      name="dateCmd"
                                      class="form-control"
                                      placeholder="Enter your order date "
                                    />
                                  </div>
                              
                                </div>
                                <div class="row g-2">
                                  <div class="col mb-0">
                                    <label for="emailWithTitle" class="form-label">Order Quantity</label>
                                    <input
                                      type="number"
                                      id="emailWithTitle"
                                      name="qteCmd"
                                      class="form-control"
                                      placeholder="Enter your Order Quantity"
                                    />
                                  </div>
                              
                                </div>
                                
                              </div>
                              <div class="modal-footer">
                                <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">
                                  Close
                                </button>
                                <input type="submit" class="btn btn-primary" value="Ajouter"/>
                              </div>
                            </div>
                          </div>
                        </div>
                      </form>
                    
  
                    
                    
                    
                    <div class="table-responsive">
                        <table class="table text-start align-middle table-bordered table-hover mb-0" >
                           <thead>
                                <tr class="text-white">
                                    <th scope="col"><input class="form-check-input" type="checkbox"></th>
                                    <th scope="col">Order Code</th>
                                    <th scope="col">clients Name</th>
                                    <th scope="col">Items Code </th>
                                    <th scope="col">Order Date </th>
                                    <th scope="col">order Quantity</th>
                                    <th scope="col">Action</th>
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
        let comm = [];
    function findAll(){	
    	$.ajax({			
    		type:"GET",
    		url:"loadAllcommande.action",
    		success: function(result){
    			var tblData="";
    			comm=result.commandes;
    			$.each(result.commandes, function() {	
    					console.log(result.articles)
    				tblData += '<tr>'
                       +' <td><input class="form-check-input" type="checkbox"></td>'
                       +'<td>'+this.codeCmd+'</td>'
                       +' <td>'+this.client+'</td>'
                       +' <td>'+this.codeArt+'</td>'
                       +' <td>'+this.dateCmd+'</td>'
                       +' <td>'+this.qteCmd+'</td>'
                       +'<td><button class="btn btn-sm btn-primary" onclick="supp('+this.codeCmd+')">Delete</button>  <a class="btn btn-sm btn-success" href="javascript:void(0);" data-bs-toggle="modal" data-bs-target="#modalEdit" onclick="edit('+this.codeCmd+')">Update</a> <a class="btn btn-sm btn-danger"  onclick="pdf('+this.codeCmd+')">Display Order</a></td>'
                       
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
    
    
        </script>
		<script type="text/javascript">
    function edit(e){
    	console.log("ok : "+e)
    	let obj = comm.find(o => o.codeCmd === e);
    	console.log(obj)

    	document.getElementById("date").value=obj.dateCmd;
    	document.getElementById("qnt").value=obj.qteCmd;
    	document.getElementById("codeArt").value=obj.codeArt;
    	document.getElementById("NomC").value=obj.client;
    	document.getElementById("CodeCmd").value=obj.codeCmd;
		
    }
     </script>


		<script type="text/javascript">
    function pdf(es){
    	console.log(es)
    	let obj = comm.find(o => o.codeCmd === es);
    	//console.log("codeCmd="+obj.codeCmd+"&codeArt="+obj.codeArt+"&client="+obj.client+"&qteCmd="+obj.qteCmd+"&dateCmd="+obj.dateCmd)
    	console.log(obj)
    	$.ajax({			
    		type:"POST",
    		url:"gereFact.action",
    		data:"codeCmd="+obj.codeCmd+"&codeArt="+obj.codeArt+"&client="+obj.client+"&qteCmd="+obj.qteCmd+"&dateCmd="+obj.dateCmd,
    	success: function(result){
    		//verFact();
    		 //window.location.href="http://localhost:8080/SalesManagement/Fact.pdf";
    		 //window.open('http://localhost:8080/SalesManagement/Fact.pdf', '_blank');
    		 $('#download').modal('show')
    	},
			error: function(result){
    			//alert("Some error occured.");
    		}
			
    	})
    
    };
    
    </script>


	<script type="text/javascript">
    function supp(es){
    	let obj = comm.find(o => o.codeCmd === es);
    	console.log(obj)
    	$.ajax({			
    		type:"POST",
    		url:"supComd.action",
    		data:"codeCmd="+obj.codeCmd+"&codeArt="+obj.codeArt+"&client="+obj.client+"&qteCmd="+obj.qteCmd+"&dateCmd="+obj.dateCmd,
    	success: function(result){
    		
    		findAll();
    	},
			error: function(result){
    			alert("Some error occured.");
    		}
			
    		
    	})
    
    };
    
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