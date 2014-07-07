package com.digiburo.naughty.collector.json;

/**
 * Created by gsc on 7/6/14.
 */
public class SelfNextLink extends AbstractLinks {
  final HrefContainer nextLink = new HrefContainer();
  final HrefContainer selfLink = new HrefContainer();

  public SelfNextLink(String nextArg, String selfArg) {
    nextLink.setHref(nextArg);
    selfLink.setHref(selfArg);
  }

  public HrefContainer getNext() {
    return nextLink;
  }

  public HrefContainer getSelf() {
    return selfLink;
  }
}
