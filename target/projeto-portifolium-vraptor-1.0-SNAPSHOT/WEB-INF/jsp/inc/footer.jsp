<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <footer class="page-footer teal">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="brown-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>


  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="<c:url value="/js/materialize.js"/>"></script>
  <script src="<c:url value="/js/init.js"/>"></script>
  <script>
         $(document).ready(function() {
            $('select').material_select();
         });
  </script>

  <script>
    var chip = {
      tag: 'chip content',
      image: '', //optional
      id: 1, //optional
    };

         $(document).ready(function() {
            $('select').material_select();
         });

         $('.chips').material_chip();

          $('.chips-initial').material_chip({
            data: [{
              tag: 'Apple',
            }, {
              tag: 'Microsoft',
            }, {
              tag: 'Google',
            }],
          });
          $('.chips-placeholder').material_chip({
            placeholder: 'Enter a tag',
            secondaryPlaceholder: '+Tag',
          });
          $('.chips-autocomplete').material_chip({
            autocompleteOptions: {
              data: {
                'Apple': null,
                'Microsoft': null,
                'Google': null
              },
              limit: Infinity,
              minLength: 1
            }
          });
          </script>

  <c:if test="${not empty errors}">
      <c:forEach items="${errors}" var="error">
          <script>
              Materialize.toast("<fmt:message key="${error.category} ${error.message}"/>", 4000)
          </script>
      </c:forEach>
  </c:if>

  <c:if test="${not empty notice}">
      <script>
          Materialize.toast("${notice}", 4000)
      </script>

      </div>
  </c:if>


  </body>
</html>
