<!DOCTYPE html>
<html>
<head>

    <!-- for jquery -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="http://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">


    <title>Spring MVC Demo</title>
</head>
<body>
    <h2>${message}</h2>


    Date (Click for calendar): <input type="text" name="mydate" id="mydate"/>

    <button id="execute">Execute</button>
    <button id="reset">Reset</button>
    <button id="stop">Stop</button>
    <div id="timer">00:00:00</div>

    <div id="progressbar">
        <div id="progress-label">
            Loading ...
        </div>
    </div>

    <div>${eodProcessData.getFirstName()}</div>
    <div>${eodProcessData.getLastName()}</div>
    <div>${eodProcessData.getMiddleName()}</div>
    <script>




        //------------------------------------------------for progressbar
        var duration = 17;

        function progressbar(){
            var progressbar = $("#progressbar");
            var progressLabel = $("#progress-label");

            progressbar.progressbar({
                value:false,
                change: function(){
                    progressLabel.text(progressbar.progressbar("value").toLocaleString(undefined,{maximumSignificantDigits:2})+"%");
                },
                complete: function(){
                    progressLabel.text("Success");
                }

            });

            function progress(){
                var val = progressbar.progressbar("value") || 0;
                var increment  = (100/duration);
                progressbar.progressbar("value", val+increment);
                if(val < 99){
                    //disable execute button while ongoing execution
                    $("#execute").prop("disabled",true);
                    setTimeout(progress,1000);
                }
            }
            setTimeout(progress,1000);
        }

        //------------------------------------------------for timer
        var interval

        $("#execute").click(function fuck(e){
            console.log("execute");
            interval = setInterval(myTimer,1000);
            //for progressbar
            progressbar();
        });

        $("#reset").click(function (e){
            console.log("reset");
            resetTimer();
        });

        $("#stop").click(function (e){
            console.log("stop");
            clearInterval(interval);
        });

        var hours = 0;
        var minutes = 0;
        var seconds = 0;
        var totalSecs = 0;

        function resetTimer(){
            seconds = 0;
            minutes = 0;
            hours = 0;

            document.getElementById("timer").innerHTML="00:00:00";
        }

        function myTimer(){
            var hh = 0;
            var mm = 0;
            var ss = 0;

            //code to stop if duration if matched
            totalSecs = totalSecs+1;
            if(duration == totalSecs){
                clearInterval(interval);
            }

            seconds = seconds+1;
            if(seconds == 60){
                seconds = 0;
                minutes = minutes+1;
                if(minutes == 60){
                    minutes = 0;
                    hours = hours+1;
                }
            }

            if(seconds < 10){
                ss = "0"+seconds;
            }else{
                ss = seconds;
            }

            if(minutes < 10){
                mm = "0"+minutes;
            }else{
                mm = minutes;
            }

            if(hours < 10){
                hh = "0"+hours;
            }else{
                hh = hours;
            }

            document.getElementById("timer").innerHTML=hh+":"+mm+":"+ss;

        }

        //------------------------------------------------for calendar

        $(function(){
            var dataUrl = "/SpringMVC/springMVC/inputDate/";
            var format = $("#mydate");
            format.datepicker({
                minDate:"-3",
                maxDate:"+3",
                onSelect:function(){
                    var selectedDate = $(this).datepicker("getDate");
                    if(selectedDate !== null){
                      $.post(dataUrl, {
                          date: selectedDate.getDate(),
                          month: selectedDate.getMonth(),
                          year: selectedDate.getFullYear(),
                      });
                    }

                },
            });

        });

        //-------------------------------status from jsp from controller
        var jspVar = "${status1}";
        if(jspVar == "failed"){
            console.log(jspVar);
            //changing status after 10seconds
            setTimeout(method1, 10000);
        }

        function method1(){
            jspVar = "pending";
            console.log(jspVar);
        }


    </script>
</body>
</html>