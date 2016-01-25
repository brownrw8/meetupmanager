<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion">
<h2 class="form-header">Review a Meetup!</h2>
<form class="review-form ajax-form" action="user" method="post">
    <div class="form-row">
    <label for="meetup">Meetup</label>
    <select name="userAttendee">
        <c:forEach items="${userAttendees}" var="userAttendee">
            <option value="${userAttendee.id}">${userAttendee.meetups.events.name} - ${userAttendee.meetups.dateAndTime}</option>
        </c:forEach>
    </select>
    </div>
    <div class="form-row">
    <label for="rating">Rating</label>
    <select name="rating">
        <c:forEach items="${ratings}" var="rating">
            <option value="${rating.id}">${rating.name}</option>
        </c:forEach>
    </select>
    </div>
    <div class="form-row">
    <label for="comments">Comment</label>
    <textarea name="comments"></textarea>
    </div>
    <input type="hidden" name="action" value="review"/>
    <div class="form-row form-actions">
        <button class="submit" type="submit" value="Submit">Submit</button>
        <button class="reset" type="reset" value="Reset">Reset</button>
    </div>
</form>
</div>