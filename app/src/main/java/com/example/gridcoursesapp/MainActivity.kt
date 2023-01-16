package com.example.gridcoursesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gridcoursesapp.data.Datasource
import com.example.gridcoursesapp.model.Topic
import com.example.gridcoursesapp.ui.theme.GridCoursesAppTheme

class MainActivity : ComponentActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
   GridCoursesAppTheme {
    // A surface container using the 'background' color from the theme
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
     TopicApp()
    }
   }
  }
 }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TopicApp() {
 LazyVerticalGrid(
  cells = GridCells.Fixed(2),
  verticalArrangement = Arrangement.spacedBy(8.dp),
  horizontalArrangement = Arrangement.spacedBy(8.dp),
  modifier = Modifier.padding(8.dp),
  content = {
   items(Datasource.loadTopics) { topic ->
    TopicCard(topic = topic);
   }
  }
 )

}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
 Card(
  modifier = modifier
//   .padding(4.dp)
   .clickable { },
  elevation = 10.dp
 ) {
  Row() {
   Box(
   ) {
    Image(
     painter = painterResource(id = topic.imageResourceId),
//     painter = painterResource(id = R.drawable.architecture),
     contentDescription = stringResource(id = R.string.architecture),
     modifier = Modifier.size(width = 71.dp, height = 75.dp),
     contentScale = ContentScale.Crop
    )
   }
   Column(
   ) {
    Text(
     text = stringResource(id = topic.stringResourceId),
     style = MaterialTheme.typography.body2,
     modifier = Modifier
      .padding(
       start = 16.dp,
       top = 16.dp,
       end = 16.dp,
       bottom = 16.dp
      ),
    )
    Row(
     verticalAlignment = Alignment.CenterVertically,
     horizontalArrangement = Arrangement.Center
    ) {
     Icon(
      painter = painterResource(id = R.drawable.ic_grain),
      contentDescription = null,
      modifier = Modifier
       .padding(start = 16.dp, end = 12.dp)
     )
     Text(
      text = topic.numberResourceId.toString(),
      style = MaterialTheme.typography.caption,
      modifier = Modifier.padding(start = 8.dp)
     )
    }
   }
  }
 }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
 GridCoursesAppTheme {
  TopicApp()
 }
}