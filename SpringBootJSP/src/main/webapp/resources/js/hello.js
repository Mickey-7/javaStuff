
$(document).ready( function(){
        function poll(){
            var newsboy = "<tbody>";
            $.ajax({
                type:"GET",
                url:"/ajax",
                success:function(data,status){
                var now  = new Date();
                    $.each(data, function(i,person){
                    var start = new Date(1614392322000);
                    var count = Math.abs(now-start);
                    console.log(count);
                        newsboy += "<tr>"
                                +"<td>"+(i+1)+"</td>"
                                +"<td>"+person.name+"</td>"
                                +"<td>"+person.description+"</td>"
                                +"<td>"
                                    +"<button class='execute-btn disabled-btn' id='button"+(i+1)+"'>"
                                        +"Execute"
                                    +"</button>"
                                +"</td>"
                                +"<td id='timer"+(i+1)+"'></td>"
                                +"<td>"+format(count)+"</td>"
                            +"</tr>";
                    });
                    newsboy += "</tbody>";
                    $("#start").html(newsboy);
                },
                error:function(){
                    console.log("error");
                }
            })
        }
        setInterval(poll,1000);

        function format(duration){
            var newDur = duration/1000;
            var hr = Math.floor(newDur/3600);
            var min = Math.floor((newDur - hr*3600)/60);
            var sec = Math.floor(newDur - hr*3600 - min*60);

            sec = sec<10? "0"+sec:sec;
            min = min<10? "0"+min:min;
            hr = hr<10? "0"+hr:hr;

            return  time = hr+":"+min+":"+sec

        }

        $("#start").on("click","button.execute-btn",function(){
            console.log("button functional")
            var id = $(this).attr("id")

        })

        var totalSec = 0;
        var duration = 77;
        function timer(id){
            $(".disabled-btn").attr("disabled",true);

            totalSec = totalSec+1;
            var hr = Math.floor(totalSec/3600);
            var min = Math.floor((totalSec - hr*3600)/60);
            var sec = totalSec - (hr*3600) - (min*60);

            sec = sec<10? "0"+sec:sec;
            min = min<10? "0"+min:min;
            hr = hr<10? "0"+hr:hr;

            var time = hr+":"+min+":"+sec;
            console.log("id: "+id+ " time -> "+time)
            $("#timer"+id).html(time);

            if(totalSec === duration){
                $(".disabled-btn").attr("disabled",false);
            }

        }

});
