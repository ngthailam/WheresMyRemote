package vn.thailam.wheresmyremote.ui.feature.addplace.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import vn.thailam.wheresmyremote.R
import vn.thailam.wheresmyremote.ui.composable.dashedBorder
import vn.thailam.wheresmyremote.ui.utils.AppDestinations

@Composable
fun AddPhoto(
    navController: NavController,
    cameraPathUri: String,
    onRemovePhoto: () -> Unit,
) {
    if (cameraPathUri.isEmpty()) {
        PhotoCapture {
            navController.navigate(AppDestinations.CAMERA)
        }
    } else {
        PhotoPreview(
            navController = navController,
            cameraPathUri = cameraPathUri,
            onRemovePhoto = onRemovePhoto,
        )
    }
}

@Composable
private fun PhotoPreview(
    navController: NavController,
    cameraPathUri: String,
    onRemovePhoto: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .aspectRatio(1f)
    ) {
        AsyncImage(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                    navController.navigate(AppDestinations.CAMERA)
                },
            model = ImageRequest.Builder(LocalContext.current)
                .data(cameraPathUri)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            contentDescription = null,
        )

        IconButton(
            modifier = Modifier
                .size(24.dp)
                .background(Color.White)
                .border(1.dp, Color.DarkGray, shape = CircleShape)
                .align(Alignment.TopEnd),
            onClick = onRemovePhoto,
        ) {
            Icon(Icons.Default.Close, contentDescription = "Close button", tint = Color.DarkGray)
        }
    }
}

@Composable
private fun PhotoCapture(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
            .aspectRatio(1f)
            .dashedBorder(1.dp, Color.Gray, 8.dp)
            .clickable {
                onClick()
            },
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
                contentDescription = "Add a photo zone",
            )
            Text(
                textAlign = TextAlign.Center, text = "Add photo"
            )
        }
    }
}