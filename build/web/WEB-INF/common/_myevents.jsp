<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="accordion">
<h2 class="table-header">View my Events!</h2>
<table class="events-table">
    <thead>
    <tr class="events-header">
        <th>Event</th>
        <th>Meetup Date</th>
        <th>RSVP</th>
        <th>Rating</th>
        <th>Comments</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${userAttendees}" var="userAttendee">
        <tr class="events-row">
        <td>${userAttendee.meetups.events.name}</td>
        <td>${userAttendee.meetups.dateAndTime}</td>
        <td>${userAttendee.isRsvp ? "Yes" : "No"}</td>
        <td>${userAttendee.ratings.name}</td>
        <td>${userAttendee.comments}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</div>
