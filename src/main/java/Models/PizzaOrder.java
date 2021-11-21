package Models;/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.31.1.5860.78bb27cc6 modeling language!*/



// line 2 "model.ump"
// line 76 "model.ump"
public class PizzaOrder
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //PizzaOrder State Machines
  public enum State { CreateOrder, WarnUser, Final, Idle, Preparation, OrderType, WaiterNotification, DriverNotification, CustomerNotification }
  private State state;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public PizzaOrder()
  {
    setState(State.CreateOrder);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public String getStateFullName()
  {
    String answer = state.toString();
    return answer;
  }

  public State getState()
  {
    return state;
  }

  public boolean outOfStock()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case CreateOrder:
        setState(State.WarnUser);
        System.out.println("out of stock in WarnUser state");
        wasEventProcessed = true;
        break;
      case Preparation:
        setState(State.WarnUser);
        System.out.println("out of stock in WarnUser state");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean orderCreated()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case CreateOrder:
        setState(State.Idle);
        System.out.println("in Idle state, waiting for deque");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean userNotified()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case WarnUser:
        setState(State.Final);
        System.out.println("order completed informing User");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean checkOrderPosition()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Idle:
        setState(State.Idle);
        System.out.println("not cooking yet still idle");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean deQueueOrder()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Idle:
        setState(State.Preparation);
        System.out.println("entering Preparation state");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean orderReady()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case Preparation:
        setState(State.OrderType);
        System.out.println("cheaking order type");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean serveOrder()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case OrderType:
        setState(State.WaiterNotification);
        System.out.println("telling waiter to deliver to table");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean deliverOrder()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case OrderType:
        setState(State.DriverNotification);
        System.out.println("telling driver to deliver to site");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean pickupOrder()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case OrderType:
        setState(State.CustomerNotification);
        System.out.println("telling customer to deliver order is ready for pick up");
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition573__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case WaiterNotification:
        setState(State.Final);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition574__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case DriverNotification:
        setState(State.Final);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private boolean __autotransition575__()
  {
    boolean wasEventProcessed = false;
    
    State aState = state;
    switch (aState)
    {
      case CustomerNotification:
        setState(State.Final);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setState(State aState)
  {
    state = aState;

    // entry actions and do activities
    switch(state)
    {
      case CreateOrder:
        // line 7 "model.ump"
//        validateStock();
//        validatePayment();
        break;
      case WarnUser:
        // line 16 "model.ump"
//        notifyOutOfStock()
        break;
      case Final:
        delete();
        break;
      case Idle:
        // line 23 "model.ump"
//        validateOrderQueue() {}
        break;
      case Preparation:
        // line 31 "model.ump"
//        validateIngredients() {}
//        updateOrderStatus() {}
        break;
      case OrderType:
        // line 40 "model.ump"
//        validateOrderType() {}
        break;
      case WaiterNotification:
        // line 49 "model.ump"
//        notifyWaiterOrderIsReady() {}
        __autotransition573__();
        break;
      case DriverNotification:
        // line 56 "model.ump"
//        notifyDriverOrderIsReady() {}
//        setAddressForDriver() {}
        __autotransition574__();
        break;
      case CustomerNotification:
        // line 64 "model.ump"
//        notifyCustomerOrderIsReady() {}
        __autotransition575__();
        break;
    }
  }

  public void delete()
  {}

}