/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () { 
   $('form.ajax-form').on('submit',function(e){
       var form = $(this);
       var box = form.find("div.form-actions");
       $.ajax({
           url:form.action,
           type:'POST',
           data:form.serialize(),
           dataType:'json',
           success:function(response){
              if(response.result==="success"){
                  box.notify("Your submission has been saved!","success",{ position:"bottom center" });
              }else if(response.result==="failure"){
                  box.notify("Your submission failed!  Try again?","error",{ position:"bottom center" });
              }else{
                  box.notify("Something went wrong.  Try again in a few!","warn",{ position:"bottom center" });
              }
           }
       });
      
       e.preventDefault();
       return false;
   });
   
   $( "input.date" ).datepicker();
   $( "select" ).select2();
   $( "span.check-wrapper" ).on('click',function(){
      $(this).toggleClass("clicked"); 
      var checkbox = $(this).find("input.checkbox");
      if(checkbox.is(':checked')){
        checkbox.prop("checked",false);
      }else{
        checkbox.prop("checked",true);
      }
   });
   $( "div.accordion" ).accordion({collapsible: true, active:false});
});