$(document).ready(function() {
//history.pushState(null, null, "MatriculaServlet?type=listar");	  
$(function() {
			$("form[name='Registration']")
					.validate(
							{
								errorClass : "my-error-class",
								validClass : "my-valid-class",
								rules : {
									txtCodAlumno : {
										required : true,
										minlength : 2
									},
									txtCodCurso : {
										required : true,
										minlength : 2
									},
								},
								messages : {
									txtCodAlumno : {
										required : "Ingrese el codigo del Alumno",
										minlength : "El codigo debe tener minimo 2 Digitos"
									},
									txtCodCurso : {
										required : "Ingrese el Codigo del Curso",
										minlength : "El codigo debe tener minimo 2 Digitos"
									}
									
								},
								submitHandler : function(form) {
									form.submit();
								}
							});
		});
});

 const dataTableOptions = {
		    	    //scrollX: "2000px",
		    	    lengthMenu: [5, 10, 15, 20, 100, 200, 500],
		    	    columnDefs: [
		    	        { className: "centered", targets: [0, 1, 2, 3, 4, 5, 6] },
		    	        { orderable: false, targets: [5, 6] },
		    	        { searchable: false, targets: [1] }
		    	        //{ width: "50%", targets: [0] }
		    	    ],
		    	    pageLength: 3,
		    	    destroy: true,
		    	    language: {
		    	        lengthMenu: "Mostrar _MENU_ registros por página",
		    	        zeroRecords: "Ningún usuario encontrado",
		    	        info: "Mostrando de _START_ a _END_ de un total de _TOTAL_ registros",
		    	        infoEmpty: "Ningún usuario encontrado",
		    	        infoFiltered: "(filtrados desde _MAX_ registros totales)",
		    	        search: "Buscar:",
		    	        loadingRecords: "Cargando...",
		    	        paginate: {
		    	            first: "Primero",
		    	            last: "Último",
		    	            next: "Siguiente",
		    	            previous: "Anterior"
		    	        }
		    	    }
		    	};
		    $(document).ready(function() {
		        $('#miTabla').DataTable(dataTableOptions);
		    });