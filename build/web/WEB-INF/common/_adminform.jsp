<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion">
<h2 class="form-header">You are a group organizer!  Create an Event!</h2>
<form class="admin-form ajax-form" action="user" method=post>
    <div class="form-row">
    <label for="name">Event Name</label>
    <input type="text" name="name" size="25">
    </div>
    <div class="form-row">
    <label for="eventCategory">Category</label>
    <select name="eventCategory">
        <c:forEach items="${eventCategories}" var="eventCategory">
            <option value="${eventCategory.id}">${eventCategory.name}</option>
        </c:forEach>
    </select>
    </div>
    <div class="form-row">
    <label for="dateAndTime">Event Date</label>
    <input class="date" type="text" name="dateAndTime">
    </div>
    <div class="form-row">
    <label for="isRecurring">Recurring Monthly</label>
    <span class="check-wrapper">
    <input class="checkbox" type="checkbox" name="isRecurring">
    </span>
    </div>
    <div class="form-row">
    <label for="latitude">Latitude</label>
    <input type="text" name="latitude">
    </div>
    <div class="form-row">
    <label for="longitude">Longitude</label>
    <input type="text" name="longitude">
    </div>
    <input type="hidden" name="action" value="create"/>
    <div class="form-row form-actions">
        <button class="submit" type="submit" value="Submit">Submit</button>
        <button class="reset" type="reset" value="Reset">Reset</button>
    </div>
</form>
</div>

