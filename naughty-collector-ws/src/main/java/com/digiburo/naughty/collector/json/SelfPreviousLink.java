package com.digiburo.naughty.collector.json;

/**
 * Created by gsc on 7/6/14.
 */
public class SelfPreviousLink extends AbstractLinks {
  final HrefContainer previousLink = new HrefContainer();
  final HrefContainer selfLink = new HrefContainer();

  public SelfPreviousLink(String previousArg, String selfArg) {
    previousLink.setHref(previousArg);
    selfLink.setHref(selfArg);
  }

  public HrefContainer getPrevious() {
    return previousLink;
  }

  public HrefContainer getSelf() {
    return selfLink;
  }
}
