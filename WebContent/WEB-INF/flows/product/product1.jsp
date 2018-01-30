<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<title>HTML Tutorial</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <script
        src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    <script>
$(document).ready(function(){
    $("button").click(function(){
		$.ajax({
            url: "./order/test/我",
            success: function(result) {
                $("#div1").text(JSON.stringify(result));
            }
        });
    });
});
</script>
    <div id="div1">
        <h2>Let jQuery AJAX Change This Text</h2>
    </div>
    <button>Send</button>
    
    
    
    <form:form enctype="multipart/form-data" action="./order/test/我" method="get">
        <label for="menu">Description</label><input type="text" name="description" value="12點結單"/><br />
        <input type="submit" name="_eventId_submit" value="Submit" />
    </form:form>
</body>
</html>