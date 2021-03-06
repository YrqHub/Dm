import 'package:flutter/material.dart';
import 'package:flutter_dm/res/strings.dart';

class LoadMoreView extends StatelessWidget {
  final bool hasMore;

  LoadMoreView(this.hasMore, {Key key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return new Container(
      padding: const EdgeInsets.all(8.0),
      child: new Center(
        child: this.hasMore
            ? const CircularProgressIndicator()
            : new Text(StringValues.EMPTY_NO_DATA_MORE),
      ),
    );
  }
}
