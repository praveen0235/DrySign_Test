package framework;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

public class Storage {
	public static final String storage_connection_string = "DefaultEndpointsProtocol=https;AccountName=dmringesterqa;AccountKey=2/aNkQZei/YeM5EChDWb+qBcPXAxCokJY4QQnPd0+G2Vq57Guanpg3SYuZx43+hJEPBD4l71wOD5X1F25n+r4w==;EndpointSuffix=core.windows.net;";
	public static  void azureBlobStorage() throws InvalidKeyException, URISyntaxException, StorageException, IOException {
		String test = System.getProperty("user.dir")+"\\ProcessedXML\\"+GenericActions.fileName+".zip";
		Storage ab = new Storage();
		ab.azurefileupload(new File(test));
	}
	
	public void azurefileupload(File file) throws InvalidKeyException, URISyntaxException, StorageException, IOException
	{
		CloudStorageAccount csa = CloudStorageAccount.parse(storage_connection_string);
		CloudBlobClient serverclient = csa.createCloudBlobClient() ;
		CloudBlobContainer container = serverclient.getContainerReference("dmr-storage/QA/IN/");
		
		CloudBlockBlob blockblob = container.getBlockBlobReference(file.getName());
		blockblob.uploadFromFile(file.getAbsolutePath());
		System.out.println("file uploaded successfully");
	}

}
