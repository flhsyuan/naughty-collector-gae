package com.digiburo.naughty.collector.json;

/**
 * Created by gsc on 7/6/14.
 */
public class SelfNextPreviousLink extends AbstractLinks {
  final HrefContainer nextLink = new HrefContainer();
  final HrefContainer previousLink = new HrefContainer();
  final HrefContainer selfLink = new HrefContainer();

  public SelfNextPreviousLink(String nextArg, String previousArg, String selfArg) {
    nextLink.setHref(nextArg);
    previousLink.setHref(previousArg);
    selfLink.setHref(selfArg);
  }

  public HrefContainer getNext() {
    return nextLink;
  }

  public HrefContainer getPrevious() {
    return previousLink;
  }

  public HrefContainer getSelf() {
    return selfLink;
  }
}
