# s3
**s3 bucket for static website hosting**
aws configure --profile test1
aws s3 ls
aws s3api create-bucket --bucket kamal-zootopia --create-bucket-configuration LocationConstraint=us-west-2 --profile test1
**Go to properties**
- edit static website hosting
  - enable static website hosting
  - hosting type static website   
**Go to permission**
- unblock s2 object from public access
- edit bucket policy
**Bucket Policy**
{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "AddPermission",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "arn:aws:s3:::kamal-zootopia/*"
        }
    ]
}
