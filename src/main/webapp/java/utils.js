var popupWindow = null;
function popup(url,width,height){
    //Si la ventana esta abierta la cerramos
    if(popupWindow!=null)
    {
        popupWindow.close();
    }
    //Calculamos el ancho y alto
    var x=(screen.width-width)/2;
    var y=(screen.height-height)/2;
    var opciones="toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, width="+width+", height="+height+", top="+y+", left="+x;
    popupWindow=window.open(url,"",opciones);
}
function getValue(cmb)
{
    var valor=cmb.options[cmb.selectedIndex].value;
    return valor;
}
function setValue(cmb,value)
{
    for(i=0;i<cmb.options.length;i++){
        if(cmb.options[i].value==value)
        {
            cmb.selectedIndex=i;
            break;
        }
    }
}

