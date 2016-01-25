<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion">
<h2 class="form-header">Sign up for a Meetup!</h2>
<form class="signup-form ajax-form" action="user" method="post">
    <div class="form-row">
    <label for="meetup">Meetup</label>
    <select name="meetup">
        <c:forEach items="${meetups}" var="meetup">
            <option value="${meetup.id}">${meetup.events.name} - ${meetup.dateAndTime}</option>
        </c:forEach>
    </select>
    </div>
    <div class="form-row">
    <label for="isRsvp">RSVP</label>
    <span class="check-wrapper">
    <input class="checkbox" type="checkbox" name="isRsvp">
    </span>
    </div>
    <input type="hidden" name="action" value="signup"/>
    <div class="form-row form-actions">
        <button class="submit" type="submit" value="Submit">Submit</button>
        <button class="reset" type="reset" value="Reset">Reset</button>
    </div>
</form>
</div>
