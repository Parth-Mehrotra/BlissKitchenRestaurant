from flask import Flask, request, json
app = Flask(__name__)
app.config['DEBUG'] = True
import stripe
import SECRETS

# Note: We don't need to call run() since our application is embedded within
# the App Engine WSGI application server.


@app.route('/bliss_delivery', methods=['POST'])
def hello():
    stripe.api_key = STRIPE_API_KEY
    
    # Get the credit card details submitted by the form
    token = request.form["stripeToken"]
    
    try:
      charge = stripe.Charge.create(
          amount=1000, # amount in cents, again
          currency="usd",
          card=token,
          description="payinguser@example.com"
      )
    except stripe.CardError, e:
      return "false"
      pass
    return "true"


@app.errorhandler(404)
def page_not_found(e):
    return 'Sorry, nothing at this URL.', 404
