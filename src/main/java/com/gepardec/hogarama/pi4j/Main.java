package com.gepardec.hogarama.pi4j;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.*;
import com.pi4j.io.gpio.PinDirection;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioCallbackTrigger;
import com.pi4j.io.gpio.trigger.GpioPulseStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSetStateTrigger;
import com.pi4j.io.gpio.trigger.GpioSyncStateTrigger;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.io.gpio.event.PinEventType;
import com.pi4j.gpio.extension.mcp.MCP3008GpioProvider;
import com.pi4j.gpio.extension.mcp.MCP3008Pin;

public class Main {
  final static GpioController gpio = GpioFactory.getInstance();
  
  // For the control of pins via MCP3008 Analog-Digital-Converter
  // check 
  //MCP3008Pin pin; 
  MCP3008GpioProvider provider;
  
  //final GpioPinDigitalOutput pin01 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
   
  
  static boolean appRunning = true;
  
  public static void main(String args[]) {
    
	  System.out.println("Hello World");
	  
	  try {
		ControlGpioExample.startGpioExample();
	} catch (InterruptedException e) {		
		e.printStackTrace();
	}
	  
	  
	System.out.println("Hello World");
    /*GpioPinDigitalInput myButton = getProvisionedPin(RaspiPin.GPIO_02);
    
    myButton.addListener(new GpioUsageExampleListener());
    
    while (appRunning) {
      
    	try {
    		gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01).high();
			Thread.sleep(500);
			gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01).low();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    }*/
    
  }
  
  
  
  //get gpio-PINS 
  
  
  
  private static GpioPinDigitalInput getProvisionedPin(Pin pin) {
    return gpio.provisionDigitalInputPin(pin,             // PIN NUMBER
      "My Finger",                   // PIN FRIENDLY NAME (optional)
      PinPullResistance.PULL_DOWN); // PIN RESISTANCE (optional)
  }
  
  
  private static class GpioUsageExampleListener implements GpioPinListenerDigital {
    public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
        // display pin state on console
        System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = "
                + event.getState());
        appRunning = false;
    }
  }

}
