<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal" id="signupModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <form id="signupForm">
	      	<label class="form-check-label">
		      	<input class="form-check-input" type="radio" name="exampleRadios" id="grade1" value="First" checked>
		      	First
   	      	</label>
   	      	<label class="form-check-label">
		      	<input class="form-check-input" type="radio" name="exampleRadios" id="grade2" value="Second">
		      	Second
	      	</label>
		    <label class="form-check-label">
		      	<input class="form-check-input" type="radio" name="exampleRadios" id="grade3" value="Third">
		      	Third
			</label>
			<br>
     			Class
     			<select class="form-control">
			  <option>1</option>
			  <option>2</option>
			  <option>3</option>
			  <option>4</option>
			  <option>5</option>
			  <option>6</option>
			</select>
			<br>
			<input class="form-control" type="text" placeholder="Number" required>
			<br>
			<input class="form-control" type="text" placeholder="Name" id="name" required>
			<button class="btn btn-primary" type="submit">Submit</button>
      	</form>
      </div>
      <div class="modal-body">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancle</button>
      </div>
    </div>
  </div>
</div>
<div class="modal" id="myModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Login</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>