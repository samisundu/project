function LoginValidate()
{
    if(document.Login.UserName.value=="")
    {
        alert("Please Enter User Name!"); 
        return false;
    }
    if(document.Login.Password.value=="")
    {
        alert("Please Enter Password!"); return false;
    }
    
}
function regValidate()
{
    if(document.Register.name.value=="")
    {
        alert("Please Enter your name!"); 
        return false;
    }
    if(document.Register.email.value=="")
    {
        alert("Please Enter your Email id!"); 
        return false;
    }
    if(document.Register.contact.value=="")
    {
        alert("Please Enter your mobile number!"); 
        return false;
    }
    if(document.Register.address.value=="")
    {
        alert("Please Enter your location!"); 
        return false;
    }
    if(document.Register.username.value=="")
    {
        alert("Please Enter username!"); 
        return false;
    }
    if(document.Register.password.value=="")
    {
        alert("Please Enter password!"); 
        return false;
    }
    
}