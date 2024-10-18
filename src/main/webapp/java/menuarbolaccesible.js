/****************************************************************
Autor: Ronald H.G.
****************************************************************/
var abrirenVentanaNueva = 0;



var tagApartado = 'a';
var docActual = location.href;
function iniciaMenu(menu){
	idMenu = menu
	menu = document.getElementById(menu);
	for(var m = 0; m < menu.getElementsByTagName('ul').length; m++){
		el = menu.getElementsByTagName('ul')[m]
		el.style.display = 'none';
		el.className = 'menuDoc';
		el.parentNode.className = 'cCerrada'
		textoNodo = el.parentNode.firstChild.nodeValue;
		nuevoNodo = document.createElement(tagApartado);
		if(tagApartado == 'a') nuevoNodo.href = '#' + textoNodo;
		nuevoNodo.className = 'tagApartado';
		nuevoNodo.appendChild(document.createTextNode(textoNodo));
		el.parentNode.replaceChild(nuevoNodo,el.parentNode.firstChild);
		nuevoNodo.onclick = function(){
			hijo = sacaPrimerHijo(this.parentNode, 'ul')
			hijo.style.display = hijo.style.display == 'none' ? 'block' : 'none';
			if(this.parentNode.className == 'cCerrada' || this.parentNode.className == 'cAbierta'){
				this.parentNode.className = this.parentNode.className == 'cCerrada' ? 'cAbierta' : 'cCerrada'
			}
			else{
				this.parentNode.className = this.parentNode.className == 'cAbiertaSeleccionada' ? 'cCerradaSeleccionada' : 'cAbiertaSeleccionada' 
			}
			return false;
		}
	}
	documentoActual(idMenu)
}
function sacaPrimerHijo(obj, tag){
	for(var m = 0; m < obj.childNodes.length; m++){
		if(obj.childNodes[m].tagName && obj.childNodes[m].tagName.toLowerCase() == tag){
			return obj.childNodes[m];
			break;
		}
	}
}
function documentoActual(menu){
	idMenu = menu
	menu = document.getElementById(menu);
	for(var s = 0; s < menu.getElementsByTagName('a').length; s++){
		if(abrirenVentanaNueva) menu.getElementsByTagName('a')[s].target = 'blank';
		enlace = menu.getElementsByTagName('a')[s].href
		if(enlace == docActual){
			menu.getElementsByTagName('a')[s].parentNode.className = 'documentoActual'
		}
		if(enlace == docActual && menu.getElementsByTagName('a')[s].parentNode.parentNode.id != idMenu){
			menu.getElementsByTagName('a')[s].parentNode.parentNode.parentNode.className = 'cAbiertaSeleccionada'
			var enlaceCatPadre = sacaPrimerHijo(menu.getElementsByTagName('a')[s].parentNode.parentNode.parentNode, 'a')
			enlaceCatPadre.onclick = function(){
				hijo = sacaPrimerHijo(this.parentNode, 'ul')
				hijo.style.display = hijo.style.display == 'none' ? 'block' : 'none';
				this.parentNode.className = this.parentNode.className == 'cAbiertaSeleccionada' ? 'cCerradaSeleccionada' : 'cAbiertaSeleccionada' 
				return false;

			} 
			nodoSig = sacaPrimerHijo(menu.getElementsByTagName('a')[s].parentNode.parentNode.parentNode, 'ul')
			nodoSig.style.display = 'block';/**/
			abrePadre(idMenu, enlaceCatPadre.parentNode)
		}
	}
}
function abrePadre(idmenu, obj){
	obj.parentNode.parentNode.className = 'cAbiertaSeleccionada'
	var nodoSig = sacaPrimerHijo(obj, 'ul')
	nodoSig.style.display = 'block';
	if(obj.parentNode.id != idmenu){
		abrePadre(idmenu, obj.parentNode.parentNode)
	}
}