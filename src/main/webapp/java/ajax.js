// JavaScript Document

/*********INICIO MENSAJES *********/

var v_mensaje0="<img src='imagenes/titulo_tiene_problemas.jpg'>" +
						"<br><br> Siga los siguientes consejos:  " +
					   	"<br><br> 1.- Aseg&uacute;rese de haber ingresado un tipo de documento de identidad " +
						"<br><br> 2.- Verificar que ha ingresado correctamente su contrase&ntilde;a. "+
						"<br><br> 3.- Si olvido su contrase&ntilde;a intente <a href=javascript:fncRecordar('Recordar'); ><b>recordar contrase&ntilde;a.</b></a>" +
						"<br><br> 4.- Si no tiene una contrase&ntilde;a puede solicitarla haciendo clik <a href=javascript:fncRecordar('Solicitar');><b>aqu&iacute; </b></a> <br><br> 5.- Si continua sin poder acceder al servicio, por favor cont&aacute;ctese con nosotros  "
		

/*MENSAJES DE RECORDAR CONTRASENA*/
var v_mensaje1 = "<img src='imagenes/titulo_recordar_contrasena.jpg'><br><br>" +
				"Seleccione el tipo de documento, luego ingrese el n&uacute;mero de documento y dar click en el bot&oacute;n validar para ayudarle a recordar su contraseña</p>";

var v_mensaje2 = "<img src='imagenes/titulo_recordar_contrasena_2.jpg'><br><br> " +
					" <br>Ahora, ingrese su respuesta secreta y dar click en el bot&oacute;n recordar.";

var v_mensaje3 = "<img src='imagenes/titulo_acceder_al_sistema.jpg'><br><br>" +
			     " Ingrese la contraseña obtenida para poder acceder al sistema. </p>";

var v_mensaje4 = "<img src='imagenes/titulo_solicitar_contrasena.jpg'><br> "
		      + " <br><br>Seleccione el tipo de documento, luego ingrese n&uacute;mero de documento y dar click en el bot&oacute;n validar";

var v_mensaje5 = "<img src='imagenes/titulo_solicitar_contrasena_2.jpg'><br><br> " +
				 " <br>Verifique si los datos mostrados son correctos y dar click el bot&oacute;n solicitar";

var v_mensaje6 = "<img src='imagenes/titulo_solicitar_contrasena_0.jpg'><br><br> " +
				 " Te enviaremos tu clave web al correo electr&oacute;nico solicitado. Previamente, por la seguridad de tu informaci&oacute;n, un representante de nuestro Centro de Contacto se comunicar&aacute; contigo</p>";


var v_mensaje7 = "<img src='imagenes/titulo_acceder_al_sistema.jpg'><br><br>" +
				 " Para mantener la absoluta confidencialidad de su informaci&oacute;n, s&iacute;rvanse cambiar la clave con la que ingres&oacute;," +
				 " por otra que sea s&oacute;lo de su conocimiento.<br><br>" +
				 " De igual manera, s&iacute;rvase ingresar una pregunta cuya respuesta sea de f&aacute;cil recordaci&oacute;n," +
				 " que le sirva de ayuda memoria en caso olvidara su clave.</p>";

var v_mensaje8="<p><b>&iquest;Tiene problemas para cambiar su contrase&ntilde;a, Pregunta y Respuesta Secreta ?</b> <br><br>Siga los siguientes consejos: </p>" +
					   	"<p> 1.- Aseg&uacute;rese de haber ingresado un tipo de documento de identidad </p>" +
						"<p> 2.- Verificar que ha ingresado correctamente su contrase&ntilde;a. </p>"+
						"<p> 3.- Si continua sin poder acceder al servicio, por favor cont&aacute;ctese con nosotros</p>"
						
var v_mensaje9 = "<img src='imagenes/titulo_solicitar_contrasena.jpg'><br><br><br>La seguridad de su informaci&oacute;n es muy importante para nosotros, por favor seleccione el tipo de documento, luego ingrese n&uacute;mero de documento y haga click en el bot&oacute;n validar.";

var v_mensaje10 = "<img src='imagenes/titulo_acceder_al_sistema.jpg'><br><br> " +
				 " <br>Por Favor Ingrese su cuenta de Email para brindarle informaci&oacute;n y estar en contacto con Usted ";
	
var v_mensaje11 = "Ya existe una solicitud de contraseña en proceso"	
				 

/*********FIN  MENSAJES DE ERROR DE INGRESO*********/

///////////INICIO INGRESOO ////////////////
function AJAXIngreso()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 	=   arrValor[0];
						CamPws 	=   arrValor[1];
						Fecha 	=   arrValor[2];
						Cuspp   =   arrValor[3];
						Tipo_Afi   =   arrValor[4];
						
						if (Rpta !='100')
						{
						
							document.getElementById("mensaje").innerHTML = v_mensaje0;
							fncMensaje(' "Número de documento" y/o "contraseña" es incorrecto')
							//fncMensaje(Rpta)
							
						}
						else
						{	
							
							if(CamPws=="1")
							{
								 
								document.getElementById("mensaje").innerHTML = v_mensaje7;
								document.getElementById("link_recordar").style.display ='none';						
								document.getElementById("link_solicitar").style.display ='none';
								document.getElementById("boton_aceptar").style.display ='none';
								document.getElementById("ing_pri").style.display ='block';
								document.getElementById("hidCuspp").value =Cuspp;	
								document.getElementById("hidTipoAfi").value =Tipo_Afi;
								document.getElementById("hidFechaNac").value =Fecha;
								if(Tipo_Afi=="V")
								{
									document.getElementById("txtFechaNac").style.display ='none';
									document.getElementById("lblFecNac").style.display ='none';
									document.getElementById("lblForFec").style.display ='none';
								}
							} 
							else
							{	//Ingresando al sistema
							//vfecha = new Date();
							//fncMensaje(vfecha)
							fncLogon();
							}
						}
							document.getElementById("indicador").style.display ='none';
					
						
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}


///////////FIN INGRESOO ////////////////

///////////INICIO VALIDACION ////////////////

function AJAXValidar()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 	=   arrValor[0];
						Pregunta 	=   arrValor[1];
						MostrarMensaje(Rpta);	
			
						if (Rpta=='100')
						{	
							document.getElementById("pregunta_secreta").style.display='block';
							document.getElementById("txtPregunta").value=Pregunta;
							document.getElementById("boton_recordar").style.display ='block';
							document.getElementById("boton_recordar2").style.display='none';
							v_mensaje = v_mensaje2
						}  
						else
						{	v_mensaje = v_mensaje0 
						
						fncMensaje(Rpta)						
						//fncMensaje(' "Número de documento" es incorrecto')
						}
						
						document.getElementById("mensaje").innerHTML = v_mensaje;		
						document.getElementById("indicador").style.display ='none';					
						
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}

///////////FIN VALIDACION ////////////////


///////////INICIO RECORDAR CONTRASENA////////////////

function AJAXRecordar()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 		=   arrValor[0];
						Contrasena 	=   arrValor[1];
						//alert(Rpta)
						MostrarMensaje(Rpta);	
						if (Rpta=='100')
						{
							document.getElementById("txtContrasena").value =  String(Contrasena);
							document.getElementById("contrasena_secreta").style.display='block';
							v_mensaje = v_mensaje3
							document.getElementById("boton_recordar").style.display ='none';
							document.getElementById("boton_ingreso").style.display ='block';
						}  
						else
						{	v_mensaje = v_mensaje0
							fncMensaje('la "Respuesta Secreta" es incorrecta')
						}
						document.getElementById("mensaje").innerHTML = v_mensaje; 
						
						document.getElementById("indicador").style.display ='none';
					
						
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}


///////////FIN RECORDAR CONTRASENA////////////////

///////////INICIO SOLICITAR CONTRASENA ////////////////


function AJAXSolicitar()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 		=   arrValor[0];
						//alert(Rpta)		
						MostrarMensaje(Rpta);	
						if (Rpta=='100')
						{
							document.frmIngresoAfiliado.txtNombre.value=String(arrValor[1])
							document.frmIngresoAfiliado.txtEmail.value=String(arrValor[2])
							document.frmIngresoAfiliado.txtTel_casa.value=String(arrValor[3])
							document.frmIngresoAfiliado.txtTel_celular.value=String(arrValor[4])
							
							document.getElementById("boton_recordar2").style.display='none';
							document.getElementById("solicitud").style.display='block';
							document.getElementById("boton_solicitar").style.display='block';
							v_mensaje = v_mensaje5
						}  
						else
						{	v_mensaje = v_mensaje0 
						
							fncMensaje('"Número de documento" es incorrecto')
						}
						document.getElementById("mensaje").innerHTML = v_mensaje;		
						
						document.getElementById("indicador").style.display ='none';
					
						
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}

///////////FIN SOLICITAR CONTRASENA ////////////////



///////////INICIO SOLICITAR CONTRASENA PASO 2 ////////////////


function AJAXSolicitar2()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 		=   arrValor[0];
						//alert(Rpta)
						if (Rpta=="100")
						{ v_mensaje = v_mensaje6 }
						else if(Rpta=="101")
						{ //v_mensaje = v_mensaje11
						fncMensaje(v_mensaje11)
						}
						else
						{ v_mensaje = v_mensaje0 }
						
						document.getElementById("mensaje").innerHTML = v_mensaje;
						document.getElementById("indicador").style.display ='none';
				}
			};
			//alert(Rpta); 
			//this.ajresultado =  function() { return josabed} ;
			
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}

///////////FIN SOLICITAR CONTRASENA PASO 2 ////////////////

///////////INICIO INGRESO 1RA VEZ ////////////////

function AJAXIngresoCambio()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 		=   arrValor[0];
					 
						if (Rpta=='100')
						{	fncLogon();	
								
						} 
						
						else
						{	
							v_mensaje = v_mensaje8
						}	 
						
						document.getElementById("mensaje").innerHTML = v_mensaje; 
						document.getElementById("indicador").style.display ='none';
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}

///////////FIN INGRESO 1RA VEZ ////////////////


///////////INICIO CAMBIO DE CONTRASENA ////////////////

function AJAXCambioContrasena()
{

	var xmlhttp, bCompleto = false;
	/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
	try
	{ 
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { 
				// Creacion del objet AJAX para IE 
				xmlhttp = new XMLHttpRequest(); 
			}
			catch (excepcion) { 
				xmlhttp = false; 
			}
		}
	}
	
	if (!xmlhttp) return null;

	this.connect = function(sURL, sMetodo, sVars)	
	{
		
		if (!xmlhttp) return false;
		bCompleto = false;
		sMetodo = sMetodo.toUpperCase();

    	try {
      		if (sMetodo == "GET") {
      			sURL = sURL + (sURL.indexOf("?")>0?"&":"?")+ sVars;
		        xmlhttp.open(sMetodo, sURL, true);
        		sVars = "";
      		}
      		else {
      			xmlhttp.open(sMetodo, sURL, true);
        		xmlhttp.setRequestHeader("Method", "POST "+sURL+" HTTP/1.1");
        		//xmlhttp.setRequestHeader("Method", "POST "+sURL);
        		xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        		xmlhttp.setRequestHeader('If-Modified-Since', 'Wed, 1 Jan 2003 00:00:00 GMT');
      		}
      		
	  		xmlhttp.onreadystatechange = function(){
				//	Estado del Objeto:    //
				ST_UNINITIALIZED 	= 0;
				ST_LOADING			= 1;
				ST_LOADED			= 2;
				ST_INTERACTIVE		= 3;
				ST_COMPLETE			= 4;


				if (xmlhttp.readyState == ST_COMPLETE && !bCompleto) {
					   bCompleto = true;
					   var results = xmlhttp.responseText; 
					   arrValor = results.split("@.@")
			
						Rpta 		=   arrValor[0];
					 
							if (Rpta=='100')
							{	
								fncMensaje('Cambio de la "Nueva Contraseña" fue satisfactorio')
							}  
							else
							{	
								fncMensaje('Cambio de la "Nueva Contraseña" NO fue satisfactorio')
							}
						document.getElementById("indicador").style.display ='none';
				}
			};
			//this.ajresultado =  function() { return josabed} ;
			xmlhttp.send(sVars);
			
		}   
		catch(excepcion) { 
			return false; 
		}
    	return true;
	};
  return this;
}

///////////FIN CAMBIO DE CONTRASENA ////////////////



var v_opcion = "";

function fncMensaje(vData)
{
	document.getElementById("txtMensaje_error").innerHTML = vData;
	//document.getElementById("mensaje_error").style.display = 'block';
}
function validarIngreso(TipoDI,NroDI,Clave)
{  	
	
	var ajaxIngreso = new AJAXIngreso();
	
	if (!ajaxIngreso) alert("XMLHTTP No Disponible");
	document.getElementById("indicador").style.display ='block';
	
	var url  = "ValidaLogin/ingreso.asp";
	var parametros = "TipoDI="+escape(TipoDI)+"&NroDI="+escape(NroDI)+"&Clave="+escape(Clave);
	//window.open(url+'?'+parametros)
	
	ajaxIngreso.connect(url, "GET",parametros);
	
	
}


function fncLogon()
{
	//window.open("datos_afiliado.asp")	;
	 location.href="datos_afiliado.asp";
}


function fncIngresoCambio(lugar)
{
	
	//alert( lugar + 'ingresoCambio')
	document.getElementById("indicador").style.display ='block';
	
	box = form.TipoDI;
	var TipoDI              =  box.options[box.selectedIndex].value;
	var NroDI               = form.txtUsuario.value;
	var Clave 				= form.txtClave.value;
	var NuevaClave 			= form.txtNuevaClave.value;
	var ConfirmacionClave 	= form.txtConfirmacionClave.value;
	var Pregunta 			= form.txtPreguntaSecreta.value;
	var RespuestaSecreta 	= form.txtRespuestaSecreta.value;
	var Email               = form.txtEmailIng.value;
	var Cuspp               = form.hidCuspp.value;
	
	var url  = "ValidaLogin/ingresoCambio.asp";
	var parametros = "TipoDI="+escape(TipoDI)+"&NroDI="+escape(NroDI)+"&Clave="+escape(Clave)+"&NuevaClave="+escape(NuevaClave)+"&ConfirmacionClave="+escape(ConfirmacionClave)+"&Pregunta="+escape(Pregunta)+"&RespuestaSecreta="+escape(RespuestaSecreta)+"&Email="+escape(Email)+"&Cuspp="+escape(Cuspp)+"&ing="+escape(lugar);
	//window.open(url+'?'+parametros)
	//alert(TipoDI)
	if (lugar=='Ingreso')
	{
			//ejecutarAjax(url,handleIngresoCambio,para);
		var ajaxIngresoCambio = new AJAXIngresoCambio();
		if (!ajaxIngresoCambio) alert("XMLHTTP No Disponible");
		document.getElementById("indicador").style.display ='block';
		ajaxIngresoCambio.connect(url, "GET",parametros);
	}
	if (lugar=='Cambio')
	{
		//ejecutarAjax(url,handleCambioContrasena,para);
		
		var ajaxCambioContrasena = new AJAXCambioContrasena();
		if (!ajaxCambioContrasena) alert("XMLHTTP No Disponible");
		document.getElementById("indicador").style.display ='block';
		ajaxCambioContrasena.connect(url, "GET",parametros);
		
		
	}
	
}

//********


//*********

function handleCambioContrasena()
{

if (http.readyState == 4) 
	{	if (http.status == 200) 
		{	
			var results  = http.responseText ;
			if (results=='100')
			{	
				fncMensaje('Cambio de la "Nueva Contraseña" fue satisfactorio')
			}  
			else
			{	
				fncMensaje('Cambio de la "Nueva Contraseña" NO fue satisfactorio')
			}
			//document.getElementById("mensaje").innerHTML = v_mensaje; 
		}
		
		document.getElementById("indicador").style.display ='none';
	}


}
function fncRecordar(opcion)
{   
      //var v_mensaje = "";
      fncMensaje('')

	document.getElementById("contrasena").style.display ='none';
	document.getElementById("boton_aceptar").style.display ='none';
	document.getElementById("boton_recordar2").style.display ='block';
	document.getElementById("boton_recordar").style.display ='none';
	document.getElementById("txtRespuesta").value="";
	//form.txtRespuesta.value="";
    document.getElementById("pregunta_secreta").style.display ='none';
	document.getElementById("link_recordar").style.display ='none';						
	document.getElementById("link_solicitar").style.display ='none';
	
	//document.getElementById("txtRespuesta").value ="";
	
	v_opcion = opcion
	if(opcion=="Recordar")
	{
		v_mensaje= v_mensaje1;			
	}
	if(opcion=="Solicitar")
	{
		v_mensaje= v_mensaje9;			
	}
	document.getElementById("mensaje").innerHTML = v_mensaje;		
}

function fncRecordarRespuesta()
{		fncMensaje('')
		document.getElementById("indicador").style.display ='block';
		box = form.TipoDI;
		txt = form.txtUsuario;
		txtRptaSecreta = form.txtRespuesta;
		var TipoDI =  box.options[box.selectedIndex].value;
		var NroDI =	txt.value;
		var RptaSecreta = txtRptaSecreta.value;
		
		var url  = "ValidaLogin/RecordarContrasena2.asp";
		var parametros = "TipoDI="+escape(TipoDI)+"&NroDI="+escape(NroDI)+"&RptaSecreta="+escape(RptaSecreta);
		
		
		var ajaxRecordar = new AJAXRecordar();
		if (!ajaxRecordar) alert("XMLHTTP No Disponible");
		document.getElementById("indicador").style.display ='block';
	
		ajaxRecordar.connect(url, "GET",parametros);

}

function fncValidarUsuario(TipoDI,NroDI)
{ 
	var parametros = "TipoDI="+escape(TipoDI)+"&NroDI="+escape(NroDI);
	//alert(v_opcion)
	if (v_opcion=="Recordar" )
		{//para el caso de RECORDAR CONTRASENA
			var url  = "ValidaLogin/RecordarContrasena1.asp";
	
				var ajaxValidar = new AJAXValidar();
				if (!ajaxValidar) alert("XMLHTTP No Disponible");
				document.getElementById("indicador").style.display ='block';
				ajaxValidar.connect(url, "GET",parametros);
		
				//ejecutarAjax(url,handleRecordar1,para);
	
		}
	if (v_opcion=="Solicitar" )
		{//para el caso SOLICITR CONTRASENA	
			var url = "ValidaLogin/SolicitarContrasena1.asp";
			//window.open(url+"?"+para ,"asas","scrollbars=yes,status=no,width=600,height=400 top=100 left=100");
			//ejecutarAjax(url,handleSolicitar1,parametros);
			var ajaxSolicitar = new AJAXSolicitar();
			if (!ajaxSolicitar) alert("XMLHTTP No Disponible");
			document.getElementById("indicador").style.display ='block';
			ajaxSolicitar.connect(url, "GET",parametros);
			
		}
}

function fncEsEmail(string) //string = cadena que representa al correo electronico
{//valida si la entrada es un correo electronico si es cierto devuelve true
	  if (string.search(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/) != -1)
		  return true;
		else
		  return false;
}



function fncSolicitar()
{	// enviando los datos de la solicitud
	fncMensaje('')
				box = form.TipoDI;
				if(box.options[box.selectedIndex].value=="0")
				{		//alert('Debe de Seleccionar el "Tipo Documento"'); 
						fncMensaje('Debe de Seleccionar el "Tipo Documento"')
						box.focus(); 
						return false;	
				}
				if(form.txtUsuario.value == "" )	
						{	//alert('Debe de ingresar su "Número de DI" y "Contreseña" '); 
							fncMensaje('Debe de ingresar su "Número de Documento" ')
							form.txtUsuario.focus(); 
							return false; 
				}
				
			    if(form.txtEmail.value == "" )	
						{	//alert('Debe de ingresar su "Número de DI" y "Contreseña" '); 
							fncMensaje('Debe de ingresar su "Email" ')
							form.txtEmail.focus(); 
							return false; 
				}
			
			
				/*if (!esEmail(form.txtEmail.value))
				{
					fncMensaje('Ingrese un "Email" válido')
					form.txtEmail.focus(); 
					return false; 
				} */
				
				if (form.txtEmail.value!="")
				{
				 //alert(fncEsEmail(form.txtEmailIng.value))
				    if(fncEsEmail(form.txtEmail.value)==false)
					{
					fncMensaje('Ingrese un "Email" válido')
					form.txtEmail.focus(); 
					return false; 
					}
				}
				
       TipoDI = form.TipoDI.options[frmIngresoAfiliado.TipoDI.selectedIndex].value;
		NroDI  = form.txtUsuario.value;
		NOMBRE = form.txtNombre.value;
		EMAIL  = form.txtEmail.value;
		TEL_CASA = form.txtTel_casa.value;
		
		/*TipoDI = document.frmIngresoAfiliado.TipoDI.options[frmIngresoAfiliado.TipoDI.selectedIndex].value;
		NroDI  = document.frmIngresoAfiliado.txtUsuario.value;
		NOMBRE = document.frmIngresoAfiliado.txtNombre.value;
		EMAIL  = document.frmIngresoAfiliado.txtEmail.value;
		TEL_CASA = document.frmIngresoAfiliado.txtTel_casa.value;
		TEL_CEL  = document.frmIngresoAfiliado.txtTel_celular.value;*/
		
		//alert(TEL_CASA.length)
		if (TEL_CASA.length < 7 ||  TEL_CASA.length >  11)
		{
			fncMensaje('Debe de ingresar un "Teléfono" válido ')
							form.txtTel_casa.focus(); 
							return false; 	
		}
		
		TEL_CEL  = form.txtTel_celular.value;
		
		if (TEL_CEL.length>0)
		{		if (TEL_CEL.length < 9)
				{
					fncMensaje('Debe de ingresar un "Teléfono Celular" válido ')
									form.txtTel_celular.focus(); 
									return false; 	
				}
				if (TEL_CEL.substring(0,1)!='9')
				{
					fncMensaje('Debe de ingresar un "Teléfono Celular" válido ')
									form.txtTel_celular.focus(); 
									return false; 	
					}
		}
	fncMensaje('')	
	document.getElementById("indicador").style.display ='block';	
	var parametros = "TipoDI="+escape(TipoDI)+"&NroDI="+escape(NroDI)+"&NOMBRE="+escape(NOMBRE)+"&EMAIL="+escape(EMAIL)+"&TEL_CASA="+escape(TEL_CASA)+"&TEL_CEL="+escape(TEL_CEL) ;
	
	var url = "ValidaLogin/SolicitarContrasena2.asp";

	//window.open(url+'?'+parametros)	

	var ajaxSolicitar2 = new AJAXSolicitar2();
	
	if (!ajaxSolicitar2) //alert("XMLHTTP No Disponible");
	document.getElementById("indicador").style.display ='block';
	
	
	ajaxSolicitar2.connect(url, "GET",parametros);
	
	
}


function handleSolicitar2()
{
		
		//alert('sol')
	if (http.readyState == 4) 
	{	if (http.status == 200) 
		{	
			var results  = http.responseText ;
			
			if (results=="100")
			{ v_mensaje = v_mensaje6 }
			else
			{ v_mensaje = v_mensaje0 }
			
			document.getElementById("mensaje").innerHTML = v_mensaje;
			
		}
		document.getElementById("indicador").style.display ='none';
	}

}
function ejecutarAjax(url,fRespuesta,params)
{
	
	if (http) 
		{	
			//var url = "ValidaLogin/ingreso.asp";
			http.open("POST", url, false);
			//alert("2");
			http.onreadystatechange = fRespuesta;
			//alert("3");
			enProceso = true;
			http.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			http.setRequestHeader("Content-Type", "text/xml; charset=iso-8859-9");
			
			//http.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			http.send(params);
		}
		else
		{
			alert('No ejecuto AJAX')
			}
}

function ejecutarAjax_New(oHttp ,url,fRespuesta,params)
{
	
	if (oHttp) 
		{	
			//var url = "ValidaLogin/ingreso.asp";
			oHttp.open("POST", url, false);
			//alert("2");
			oHttp.onreadystatechange = fRespuesta;
			//alert("3");
			enProceso = true;
			oHttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
			oHttp.send(params);
		}
		else
		{
			alert('No ejecuto AJAX')
			}
}


function MostrarMensaje(NroError) 
{
	
	if (NroError !='100')
	{//alert(v_mensaje);
		
		document.getElementById("mensaje").innerHTML = v_mensaje0;
	}else
	{
		//alert("Ingreso Exito");
		var xxx=null
	}
}

function getHTTPObject() 
{
    http_request = false;
	try
	{ 
		http_request = new ActiveXObject("Msxml2.XMLHTTP"); 
	}
	catch (excepcion) 
	{ 
		try 
		{ 
	     	// Creacion del objeto AJAX para navegadores no IE
			http_request = new ActiveXObject("Microsoft.XMLHTTP"); 
		}
		catch (excepcion)
			{ 
			try { // Creacion del objet AJAX para IE  
				http_request = new XMLHttpRequest(); 
				}
			catch (excepcion) 
				{ 
					http_request = false; 
				}
		}
	}
	  
  		return http_request;
   }

function getHTTPObject_ant() {
var xmlhttp;
/*@cc_on
@if (@_jscript_version >= 5)
try {
xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
} catch (e) {
try {
xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
} catch (E) { xmlhttp = false; }
}
@else
xmlhttp = false;
@end @*/
if (!xmlhttp && typeof XMLHttpRequest != 'undefined') {
try {
xmlhttp = new XMLHttpRequest();
} catch (e) { xmlhttp = false; }
}
return xmlhttp;
}

var http = getHTTPObject();
