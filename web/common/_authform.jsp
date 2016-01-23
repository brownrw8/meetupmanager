<%-- 
    Document   : _authform
    Created on : Jan 19, 2016, 7:54:37 PM
    Author     : Rob
--%>
<h2 class="auth-form-header">Secure User Authentication</h2>
<form class="auth-form" action="auth" method=post>
    <div class="form-row">
    <label for="username">Username</label>
    <input type="text" name="username" size="25">
    </div>
    <div class="form-row">
    <label for="password">Password</label>
    <input type="password" size="15" name="password">
    </div>
    <div class="form-row form-actions">
        <button class="submit" type="submit" value="Submit">Submit</button>
        <button class="reset" type="reset" value="Reset">Reset</button>
    </div>
</form>