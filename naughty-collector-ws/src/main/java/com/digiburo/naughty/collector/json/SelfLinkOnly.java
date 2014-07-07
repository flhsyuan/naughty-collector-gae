package com.digiburo.naughty.collector.json;

/**
 * Created by gsc on 7/6/14.
 */
public class SelfLinkOnly extends AbstractLinks {
  final HrefContainer selfLink = new HrefContainer();

  public SelfLinkOnly(String arg) {
    selfLink.setHref(arg);
  }

  public HrefContainer getSelf() {
    return selfLink;
  }
}