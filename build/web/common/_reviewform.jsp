
<h2 class="form-header">Review an Event!</h2>
<form class="review-form" action="user?action=review" method=post>
    <div class="form-row">
    <label for="eventses">Event</label>
    <input type="text" name="eventses" size="25">
    </div>
    <div class="form-row">
    <label for="rating">Rating</label>
    <input type="text" size="15" name="rating">
    </div>
    <div class="form-row">
    <label for="comments">Comment</label>
    <textarea name="comments"></textarea>
    </div>
    <div class="form-row form-actions">
        <button class="submit" type="submit" value="Submit">Submit</button>
        <button class="reset" type="reset" value="Reset">Reset</button>
    </div>
</form>