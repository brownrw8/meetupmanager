# Meetup Manager
A simple app to manage categorized meetups between many users.

## Details
### Database
This application is using a MySQL database (see /src/db) which defines the basic data structure used by the application.


![Alt text](/src/images/structure.png "Current Structure")

### Frontend
This application functions primarily as a single-page AJAX application where users can perform the following actions:

•	Users can attend various events, comment on and rate them, as well as manage their own events for others to attend
•	Events are categorized by Event Category
•	1-5 Rating scale (Excellent, Very Good, Good, Mediocre Poor)
•	Events can be scheduled for a specific date and time
•	Users can RSVP to an event before it occurs
•	Coordinates are stored for the event’s location

![Alt text](/src/images/frontend.png "Frontend")
