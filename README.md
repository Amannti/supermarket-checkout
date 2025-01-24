# Coding Kata

All technical interviews taken with _Haiilo_ will be performed in the same manner, in order to minimise variance in the recruitment process. This should ensure the interview process is fair to the candidates, and also that _Haiilo_ do not miss opportunities to hire good candidates.

The interview exercise that we will use during in person technical interviews is the "Checkout Kata", which is described below, with annotations. The wording of the kata has been carefully crafted to provide a specific set of challenges and crutches to a candidate.

## The Excercise:

### Implement the code for a supermarket checkout that calculates the total price of a number of items.

### Items each have their own price, which can change frequently.

### There are also weekly special offers for when multiple items are bought.

### An example of this would be "Apples are 50 each or 3 for 130".

### The pricing table example:

| Item   |Price for 1 item | Offer                |
|--------|-----------------|----------------------|
| Apple  | 30              | 2 for 45             |
| Banana | 50              | 3 for 130            |
| Peach  | 60              |  -                   |
| Kiwi   | 20              |  -                   |

The checkout accepts the items in any order, so that if we scan an apple, a banana and another apple, we'll recognise two apples and apply the discount of 2 for 45.

Please work as you would do in your usual job. We don't accept one single commit. We want to see the steps you would do usually.

# How to start the app  

**Requirements:** docker, gradle, java 21, node 18, npm 9

1. Database
   1. ```cd ~/db```
   2. Execute ```docker compose up -d``` (ensure your docker is running and your ports a free)
2. Backend
   1. ```cd ~/backend```
   2. Execute ```gradle wrapper```
   3. Execute ```./gradlew bootRun```
3. Frontend
   1. Use new terminal
   2. ```cd ~/frontend```
   3. Execute ```npm i```
   4. Execute ```ng serve```

Optional: Start everything with your IDE, if possible

# Possible next steps  

- Admin section
  - See all paid carts and which offers were used
  - Change item prices
  - Add items
  - Enable or disable offers
  - Add new offers
- Check out code for some refactorings
- Write tests for the calculation part in the backend
- Add error handling in frontend
- Add something like loading spinners in frontend
- Improve Styling
- Think about linting 
- Write documentation and update planning notes

# Conclusion

Very cool exercise, but next time I would focus more on the calculation part with tests and less on the frontend part. 