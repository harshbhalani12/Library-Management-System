/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var canvas = document.getElementById('canvas');
var ctx = canvas.getContext('2d');
ctx.strokeStyle = '#28d1fa';
ctx.lineWidth = 15;
ctx.lineCap = 'round';
ctx.shadowBlur = 10;
ctx.shadowColor = '#28d1fa';

function degToRad(degree) {
    var factor = Math.PI / 180;
    return degree * factor;
}

function renderTime() {

    var now = new Date();
    var today = now.toDateString();
    var time = now.toLocaleTimeString();
    var hours = now.getHours();
    var minutes = now.getMinutes();
    var seconds = now.getSeconds();
    var milliseconds = now.getMilliseconds();
    var newSeconds = seconds + (milliseconds / 1000);
    //background
    gradient = ctx.createRadialGradient(250, 250, 5, 250, 250, 300);
    gradient.addColorStop(0, '#09303a');
    gradient.addColorStop(1, 'black');
    ctx.fillStyle = gradient;

    //ctx.fillStyle = '#333333';
    ctx.fillRect(0, 0, 500, 500);

    //hours
    ctx.beginPath();
    ctx.arc(250, 250, 200, degToRad(270), degToRad((hours * 30)-90));
    ctx.stroke();


    //minutes
    ctx.beginPath();
    ctx.arc(250, 250, 170, degToRad(270), degToRad((minutes * 6) - 90));
    ctx.stroke();

    //seconds
    ctx.beginPath();
    ctx.arc(250, 250, 140, degToRad(270), degToRad((newSeconds * 6) - 90));
    ctx.stroke();

    //date
    ctx.font = "25px Arial";
    ctx.fillStyle = '#28d1fa';
    ctx.fillText(today, 160, 250);


    //time
    ctx.font = "22px Arial";
    ctx.fillStyle = '#28d1fa';
    ctx.fillText(time, 160, 280);


    var dataURL = canvas.toDataURL();
    document.getElementById('myImage').src = dataURL;
}
setInterval(renderTime, 40);
       


