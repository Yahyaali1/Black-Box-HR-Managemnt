/**
 * Created by IBM on 26/01/2017.
 */






$(document).ready(function() {
    var movementStrength = 25;
    var height = movementStrength / $(window).height();
    var width = movementStrength / $(window).width();
    $("#top-image").mousemove(function(e){
        var pageX = e.pageX - ($(window).width() / 2);
        var pageY = e.pageY - ($(window).height() / 2);
        var newvalueX = width * pageX * -1 - 25;
        var newvalueY = height * pageY * -1 - 50;
        $('#top-image').css("background-position", newvalueX+"px     "+newvalueY+"px");
    });

});

function update_applicant_info() {
    var v=document.getElementById("updateformbutton");
    v.disabled=false;
    //var v=$("#update_name_first");
}

function btntest_onclick()
{
    window.location.href = "http://localhost:8090/main/Login.jsp";
}

function on_apply(a){
    var x=a;
    var button=document.getElementById(x);
    button.disabled=true;
    button.innerHTML="Log In"
    button.className="btn-danger btn-lg btn-block"
   // button.disable();
    var siginbutton= document.getElementById("inputid");
    siginbutton.focus();

   $("#notification").html('<div class="col-lg-12"> <div class="alert alert-danger alert-dismissable fade in"> <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a> <strong></strong> Please log in to apply for job ! </div> </div>');
}

function on_mark_select(ref,b){

    var idmy=ref.id;
    var rowid=parseInt(idmy.match(/\d+$/)[0], 10);


    var form= document.getElementById("smeapplication");
    form.elements[1].value=rowid;

    if(b==true){

        form.elements[2].value="true";


    }else {
        form.elements[2].value="false";
    }
    form.submit();



}

function creat_modal(a){

    var button=a;
    var tr=button.parentNode;


}

function submit_form_marks_sme(a) {
 var button=a;

 var tr=a.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode.parentNode;
 var buttonid=tr.id+"button";
 var forms=tr.id+"forms";
    document.getElementById(tr.id+"forms");
    $("#"+tr.id+"modal").modal('hide');

    var button=document.getElementById(tr.id+"button");
    button.disabled=true;


}

function newapplication(a,ref) {
    var check=a;
    var form=document.getElementById("newapp");
    var button=ref;

    var rownumber=ref.id; //id of the row
    var numb = parseInt(rownumber.match(/\d+$/)[0], 10);
    var smelist=document.getElementById("list"+numb);
    var timelist=document.getElementById("timings"+numb);
    var daylist=document.getElementById("day"+numb);
    if(a==false){

            form.elements[1].value="false"; //submiting that application needs to be remove
            form.elements[2].value=numb; //submitting the job id
            form.submit();


    }else {

            form.elements[1].value="true"; //submiting that application needs to be remove
            form.elements[2].value=numb;

            //submitting the job id
            if(timelist.value=="" || daylist.value=="" || smelist[smelist.selectedIndex].value==""){
                alert("Kindly select the Date and timings before submiting the form !");

            }else {
                var today=new Date();
                var x= new Date(timelist.value);
                if(x<today){
                    alert("date entered is not valid ");
                }else {
                    var smeid=smelist[smelist.selectedIndex].value;
                    //var smeid=parseInt(smeid.match(/\d+$/)[0], 10);
                    form.elements[3].value=smeid;
                    form.elements[4].value=timelist.value;
                    form.elements[5].value=daylist.value;

                    form.submit();
                }




            }




    }

}

function forwardtomanger(a,ref) {
    var check=a;

    var button=ref;
    var numb = parseInt(ref.id.match(/\d+$/)[0], 10);

    var form=document.getElementById("newapp2"); //getting the required form
    if(a==true){
                alert("Sending to Manager");
                form.elements[1].value="true";
                form.elements[2].value=numb;
                form.submit();


    }else {
        form.elements[1].value="false";
        form.elements[2].value=numb;
        form.submit();



    }

}

function load(a) {
    var selection=a; //id of the list
    var listid="#"+a.id;
    var sme= $("#listid option:selected").attr('id');
    alert(sme);
    var rownumber=a.parentNode.parentNode.id; //id of the row
    var numb = rownumber.match(/\d/g); //id extracted to add timings

    var select="#timings"+numb;
    $(select).html('');

    if(sme==1){
        $(select).html('<option id="sme1">Javaid</option>');
    }




}

function offerletter(a,ref){
    var select_list=ref;


    var numb = parseInt(ref.id.match(/\d+$/)[0], 10);

    var form=document.getElementById("newapp3"); //getting the required form
    if(a==true){
        alert("Sending an Offer");
        form.elements[1].value="true";
        form.elements[2].value=numb;
        form.submit();


    }else {
        form.elements[1].value="false";
        form.elements[2].value=numb;
        form.submit();



    }


}

function markhrm(ref) {
    var button_plan=ref;
    var numb =parseInt(ref.id.match(/\d+$/)[0], 10);

    var form=document.getElementById("formplan");
    var time=document.getElementById("timings"+numb);
    var day=document.getElementById("day"+numb);

    if(time.value=="" ||day.value==""){

        alert("Kindly Select time and date value ");

    }else {

        var today=new Date();
        var x= new Date(time.value);
        if(x<today){
            alert("date entered is not valid ");
        }else {
            form.elements[1].value=numb;
            form.elements[2].value=time.value;
            form.elements[3].value=day.value;

            form.submit();
        }

    }




}
function onchangetimings(ref) {
    var select_list=ref;
    var rowid=ref.id.match(/\d/g);

    var plan=document.getElementById("plan"+rowid);
    plan.removeAttribute("disabled");

    var mark=document.getElementById("mark"+rowid);
    mark.setAttribute("disabled","");




}
function addmarkshrm(ref) {

    var select_list=ref;
    var rowid=ref.id.match(/\d/g);
    document.getElementById(rowid+"forms").submit();


    document.getElementById("day"+rowid).setAttribute("disabled","");
    document.getElementById("timings"+rowid).setAttribute("disabled","");

    var plan=document.getElementById("plan"+rowid);
    plan.setAttribute("disabled","");

    var mark=document.getElementById("mark"+rowid);
    mark.setAttribute("disabled","");


    document.getElementById(rowid+"score"+1).innerHTML="55";


}

function btn_edit(ref) {
    var rowid=parseInt(ref.id.match(/\d+$/)[0], 10);

    document.getElementById("email"+rowid).removeAttribute("disabled");


    document.getElementById("pass"+rowid).removeAttribute("disabled");


    document.getElementById("buttonupdate"+rowid).removeAttribute("disabled");


}

function btn_save(ref) {
    var rowid=parseInt(ref.id.match(/\d+$/)[0], 10);

    document.getElementById("email"+rowid).setAttribute("disabled","");
    document.getElementById("pass"+rowid).setAttribute("disabled","");
    document.getElementById("buttonupdate"+rowid).setAttribute("disabled","");

    var email=document.getElementById("email"+rowid);
    var pass=document.getElementById("pass"+rowid)
    email=email.value;
    pass=pass.value;

    var form = document.getElementById("adminchange");
    form.elements[1].value=email;
    form.elements[2].value=pass;
    form.submit();


}

function btn_rem(ref) {
    var rowid=parseInt(ref.id.match(/\d+$/)[0], 10);
    var email=document.getElementById("email"+rowid);
    var form = document.getElementById("admindelete");
    form.elements[1].value=email;
    form.submit();



}


function btn_apply_job(ref) {

    var rowid=parseInt(ref.id.match(/\d+$/)[0], 10);
    var form= document.getElementById("applyforjob")
    form.elements[1].value=rowid;
    form.submit();

    ref.setAttribute("disabled","");
    ref.innerHTML="Applied";
    ref.setAttribute("class"," btn-warning btn-lg btn-block");



}
function onjobselection(a){
    var jobselected=a;

    var form=document.getElementById("selectjob");
    form.elements[1].value=jobselected.options[jobselected.selectedIndex].value;

    form.submit();
}

function displaysmemarksheet(a) {
    a=a.id
    var rowid=parseInt(a.match(/\d+$/)[0], 10);

    var form=document.getElementById("1forms");
    form.elements[1].value=rowid;


    $("#new").modal();
}
function onhrmlistchange(a) {
    a=a.options[a.selectedIndex].value;

    var form=document.getElementById("yahya");
    form.elements[1].value=a;
    form.submit();
}

function displaysmemarksheethrm(a) {
    a=a.id
    var rowid=parseInt(a.match(/\d+$/)[0], 10);

    var form=document.getElementById("hrmformmark");
    form.elements[1].value=rowid;
    $("#new1").modal();
}

function signupvalidate() {
    var form=document.getElementById("signupform");


    form.submit();

}

function emailvalidate(a) {
var msg= document.getElementById("checkemail");
var email=a.value;

    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var st = this.responseText;
            if(st=="1"){
                msg.innerHTML="Wrong email";
                msg.style.display='block';
                msg.className='text-danger'

            }else {
                msg.innerHTML="Correct Email";
                msg.style.display='block';
                msg.className='text-success'

            }

        }
    };

    xhttp.open("POST", "/doemailval", true);
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("email="+email);


}