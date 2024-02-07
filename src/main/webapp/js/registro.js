$(document).ready(function() {
    $(function() {
        $("form[name='Registration']").validate({
            errorClass: "my-error-class",
            validClass: "my-valid-class",
            rules: {
                txtNombre: {
                    required: true,
                    minlength: 2
                },
                txtContrasena: {
                    required: true,
                    minlength: 5
                },
                txtRol: {
                    required: true
                }
            },
            messages: {
                txtNombre: {
                    required: "Ingrese el nombre del usuario",
                    minlength: "El nombre debe tener al menos 2 caracteres"
                },
                txtContrasena: {
                    required: "Ingrese la contraseña",
                    minlength: "La contraseña debe tener al menos 5 caracteres"
                },
                txtRol: {
                    required: "Seleccione el rol del usuario"
                }
            },
            submitHandler: function(form) {
                form.submit();
            }
        });
    });
$(function() {
				$("form[name='RetiroServlet']").validate({
					errorClass : "my-error-class",
					validClass : "mu-valid-class",
					rules : {
						numRetiro : {
							required : false
						},
						numMatricula : {
							required : true
						},
						fecha : {
							required : true
						},
						hora : {
							required : false
						}
					},
					messages : {
						numRetiro : {
							required : "Se Autocompleta",
						},
						numMatricula : {
							required : "Se Mostrar� al buscar el DNI",
						},
						fecha : {
							required : "Ingrese la fecha de Retiro",
						},
						hora : {
							required : "Ingrese la Hora de Retiro",
						},
					},
					submitHandler : function(form) {
						form.submit();
					}
				});
			});
    const dataTableOptions = {
        lengthMenu: [5, 10, 15, 20, 100, 200, 500],
        columnDefs: [
            { className: "centered", targets: [0, 1, 2, 3, 4] },
            { orderable: false, targets: [4] }
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
jQuery('#divRetiroAlumno').css("overflow-y", "auto");
    $(document).ready(function() {
        $('#miTabla').DataTable(dataTableOptions);
    });
});

