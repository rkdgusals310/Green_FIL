<html lang='ko'>
<head>
<meta charset='UTF-8' />
<link href='${pageContext.request.contextPath}/resources/fullcalendar-5.1.0/lib/main.css' rel='stylesheet' />
<script src='${pageContext.request.contextPath}/resources/fullcalendar-5.1.0/lib/main.js'></script>
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script type='text/javascript'>

document.addEventListener('DOMContentLoaded', function() {
  var calendarEl = document.getElementById('calendar');

  var calendar = new FullCalendar.Calendar(calendarEl, {
    googleCalendarApiKey:'AIzaSyAj7WwJTC5l1BuFpOXbnIeaqYSfF2KC_pI',
    eventSources: [
               {
            	  	googleCalendarId:'t3daid8qcjh2jro60cj64m1815odcdom@import.calendar.google.com',
              		className: '날짜',
              		color:'#07c8f9'
              },
              {
                  googleCalendarId: '08c7feb0c5da4817e738b086c71fc4e980088ced243a0b56dad253563ec01753@group.calendar.google.com',
                  className: '날씨의 일기'
                 
                  
                },
                {
                    googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com',
                    className: '공휴일',
                    	 color:'#cb1b16'
                      //textColor: 'black' 
                  }
              
           
    ]
  
    /*     {
            googleCalendarId: 'ko.south_korea#holiday@group.v.calendar.google.com',
            className: '공휴일'
             
              //textColor: 'black' 
          },
        {
            googleCalendarId: '08c7feb0c5da4817e738b086c71fc4e980088ced243a0b56dad253563ec01753@group.calendar.google.com',
            className: '날씨의 일기',
              color: '#204051'
          } */
      

  });
  calendar.render();
});
</script>
<style>
#calendar {
	width: 60%;
	margin: 20px auto;
}
</style>
</head>
<body>
	<div id='calendar'></div>
</body>
</html>