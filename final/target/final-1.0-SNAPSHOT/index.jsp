<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Track your dough</title>
</head>
<body>
<h1>Track your dough</h1>
<br/>
 <%--
 index.jsp
 1. input for the name of the expense   DONE
 2. input for the category of the expense   DONE
        a list of categort  DONE
 3. input for the amount of the expense    DONE
 4. add button DONE
        adds the inputs into a data frame[df_expences]
        clears the form for a new entry
 5. new from button
        deletes the saved entries from the data frame
 6. analyze button DONE
        redirects to a new page [analysis.jsp]
 7. how to button DONE
        redirects to new page [howto.jsp]

 analysis.jsp
 1. table of expenses
        pulls values from df_expences data frame
 2. chart of expenses
        pie chart, groupby categories in df_expences


 howto.jsp
 1. screen shots of how to use the app
 --%>

<form action="datasvingServlet" method="post">

    <button type="button" name="howto" onclick="window.location='howto.jsp'">HOW TO</button>

    <br/>

    Name of expense:     <input type="text" name="expName" >
    Category of expense: <input type="text" type="text" name="expCategory">
    Amount:             $<input type="text" name="expAmount" min="0" value="0" step="0.01">
    <br/>

    <button type="button" name="add" value="add">Add</button>
    <button type="button" name="clear" value="clear">Clear</button>
    <button type="button" name="analyze" onclick="window.location='analysis.jsp'">Analyze</button>
    <input type="submit" value="Submit" />

    <br/>



    <datalist id="expCategoryList">
        <option value="type1"/>
        <option value="type2"/>
        <option value="type3"/>
        <option value="type4"/>
    </datalist>
</form>


</body>
</html>